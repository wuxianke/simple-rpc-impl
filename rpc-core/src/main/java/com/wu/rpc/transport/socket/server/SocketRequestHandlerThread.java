package com.wu.rpc.transport.socket.server;

import com.wu.rpc.entity.RpcRequest;
import com.wu.rpc.entity.RpcResponse;
import com.wu.rpc.handler.RequestHandler;
import com.wu.rpc.registry.ServiceRegistry;
import com.wu.rpc.serializer.CommonSerializer;
import com.wu.rpc.transport.socket.util.ObjectReader;
import com.wu.rpc.transport.socket.util.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

public class SocketRequestHandlerThread implements Runnable{
    private static final Logger logger = LoggerFactory.getLogger(SocketRequestHandlerThread.class);
    private Socket socket;
    private RequestHandler requestHandler;
    private CommonSerializer serializer;

    public SocketRequestHandlerThread(Socket socket, RequestHandler requestHandler, CommonSerializer serializer) {
        this.socket = socket;
        this.requestHandler = requestHandler;
        this.serializer = serializer;
    }

    @Override
    public void run() {
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()) {
            RpcRequest rpcRequest  = (RpcRequest) ObjectReader.readObject(inputStream);
            Object result = requestHandler.handle(rpcRequest);
            RpcResponse<Object> response = RpcResponse.success(result, rpcRequest.getRequestId());
            ObjectWriter.writeObject(outputStream, response, serializer);
        }catch (IOException e){
            logger.error("调用或发送时有错误发生", e);
        }
    }
}
