package com.wu.rpc.client;

import com.wu.rpc.entity.RpcRequest;
import com.wu.rpc.exception.RpcException;
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


}
