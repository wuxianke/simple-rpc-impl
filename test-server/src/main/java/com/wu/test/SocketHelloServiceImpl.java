package com.wu.test;

import com.wu.rpc.annotation.Service;
import com.wu.rpc.api.HelloObject;
import com.wu.rpc.api.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 服务端提供的HelloService方法。
 */
@Service
public class SocketHelloServiceImpl implements HelloService {

    private static final Logger logger = LoggerFactory.getLogger(SocketHelloServiceImpl.class);

    @Override
    public String hello(HelloObject object) {
        logger.info("接收到消息：{}", object.getMessage());
        return "本次hello服务来自Socket服务";
    }
}
