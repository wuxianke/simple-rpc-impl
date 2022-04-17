package com.wu.rpc.transport;

import com.wu.rpc.entity.RpcRequest;
import com.wu.rpc.exception.RpcException;
import com.wu.rpc.serializer.CommonSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 客户端类通用接口
 * @author Cactus
 */
public interface RpcClient {

    Object sendRequest(RpcRequest rpcRequest);

    void setSerializer(CommonSerializer serializer);
}
