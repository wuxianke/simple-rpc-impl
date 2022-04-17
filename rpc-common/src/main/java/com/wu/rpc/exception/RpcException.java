package com.wu.rpc.exception;

import com.wu.rpc.enumeration.RpcError;

/**
 * Rpc调用异常
 * @author Cactus
 */
public class RpcException extends RuntimeException{
    public RpcException(RpcError error, String detail){
        super(error.getMessage()+": " + detail);
    }
    public RpcException(String message, Throwable cause){
        super(message, cause);
    }

    public RpcException(RpcError error){
        super(error.getMessage());
    }
}
