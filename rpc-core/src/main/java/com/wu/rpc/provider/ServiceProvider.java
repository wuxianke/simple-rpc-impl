package com.wu.rpc.provider;

/**
 * 本地保存和提供服务实例对象
 * @author Cactus
 */
public interface ServiceProvider {

    /**
     * 向本地注册服务
     * @param service 服务
     * @param <T>服务类型
     */
    <T> void addServiceProvider(T service, Class<T> serviceClass);

    /**
     * 从本地缓存中获得服务。
     * @param serviceName 服务名称
     * @return 服务实例
     */
    Object getServiceProvider(String serviceName);
}
