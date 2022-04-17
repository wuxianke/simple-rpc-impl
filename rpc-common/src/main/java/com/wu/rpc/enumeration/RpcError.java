package com.wu.rpc.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Rpc在调用过程中的错误
 * @author Cactus
 */
@AllArgsConstructor
@Getter
public enum RpcError {

    /**
     * 服务错误枚举类
     */
    SERVICE_INVOCATION_FAILURE("服务调用失败"),
    SERVICE_CAN_NOT_BE_NULL("注册的服务不能为空"),
    SERVICE_NOT_FOUND("找不到对应的服务"),
    SERVICE_NOT_IMPLEMENT_ANY_INTERFACE("注册的服务未实现接口"),
    UNKNOWN_PROTOCOL("不认识的协议包"),
    UNKNOWN_SERIALIZER("不认识的(反)序列化器"),
    UNKNOWN_PACKAGE_TYPE("不识别的数据包类型"),
    SERIALIZER_NOT_FOUND("找不到序列化器"),
    RESPONSE_NOT_MATCH("响应和请求号不匹配"),
    CLIENT_CONNECT_SERVER_FAILURE("客户端连接无法连接到服务器"),
    FAILED_TO_CONNECT_TO_SERVICE_REGISTRY("连接注册中心失败"),
    REGISTER_SERVICE_FAILED("注册服务失败");

    private final String message;
}
