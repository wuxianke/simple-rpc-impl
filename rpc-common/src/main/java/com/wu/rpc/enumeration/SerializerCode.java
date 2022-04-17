package com.wu.rpc.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 字节流中标识的序列化和反序列化
 * @author Cactus
 */
@AllArgsConstructor
@Getter
public enum SerializerCode {
    /**
     * 不同序列化方式对应的标识
     */
    KRYO(0),
    JSON(1),
    HESSIAN(2),
    PROTOBUF(3);

    private final int code;
}
