package com.wu.rpc.exception;

/**
 * 序列化异常
 * @author Cactus
 */
public class SerializeException extends RuntimeException{
    public SerializeException(String msg){
        super(msg);
    }
}
