package com.wu.rpc.registry;

import java.net.InetSocketAddress;

/**
 * 服务注册表接口
 * @author Cactus
 */
public interface ServiceRegistry {

    /**
     * 向nacos注册服务。
     * @param serviceName 服务名称
     * @param inetSocketAddress 提供服务的地址
     */
    void register(String serviceName, InetSocketAddress inetSocketAddress);

}
