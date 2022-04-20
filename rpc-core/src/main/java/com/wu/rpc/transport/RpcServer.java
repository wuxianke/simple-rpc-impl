package com.wu.rpc.transport;

import com.wu.rpc.serializer.CommonSerializer;

/**
 * 服务端通用接口
 * @author Cactus
 */
public interface RpcServer {

    int DEFAULT_SERIALIZER = CommonSerializer.KRYO_SERIALIZER;

    void start();

    <T> void publishService(T service, String serviceName);
}
