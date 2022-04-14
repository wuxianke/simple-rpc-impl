package com.wu.test;

import com.wu.rpc.api.HelloObject;
import com.wu.rpc.api.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 服务端提供的HelloService方法。
 */
public class HelloServiceImpl implements HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public Object hello(HelloObject object) {
        logger.info("接收到：{}", object.getMessage());
        return "这是掉用的返回值，id = " + object.getId();
    }
}
