package com.wu.rpc.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 包类型枚举类
 * @author Cactus
 */

@AllArgsConstructor
@Getter
public enum PackageType {

    /**
     * 请求包和响应包
     */
    REQUEST_PACK(0),
    RESPONSE_PACK(1);

    private final int code;
}
