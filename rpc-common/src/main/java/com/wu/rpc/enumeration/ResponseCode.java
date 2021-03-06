package com.wu.rpc.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * @author Cactus
 */

@AllArgsConstructor
@Getter
public enum ResponseCode {
    /**
     * 相关响应码。
     */
    SUCCESS(200,"调用方法成功"),
    FAIL(500,"调用方法失败"),
    METHOD_NOT_FOUND(500,"未找到指定方法"),
    ClASS_NOT_FOUND(500,"未找到指定类");


    private final int code;
    private final String message;

}
