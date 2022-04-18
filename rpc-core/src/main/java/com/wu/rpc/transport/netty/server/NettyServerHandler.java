package com.wu.rpc.transport.netty.server;

import com.wu.rpc.entity.RpcRequest;
import com.wu.rpc.entity.RpcResponse;
import com.wu.rpc.factory.SingletonFactory;
import com.wu.rpc.handler.RequestHandler;
import com.wu.rpc.factory.ThreadPoolFactory;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;

public class NettyServerHandler extends SimpleChannelInboundHandler<RpcRequest> {

    private static final Logger logger = LoggerFactory.getLogger(NettyServerHandler.class);
    private final RequestHandler requestHandler;
    public NettyServerHandler(){
        this.requestHandler = SingletonFactory.getInstance(RequestHandler.class);
        //引入异步业务线程池，避免长时间的耗时业务阻塞netty本身的worker工作线程，耽误了同一个Selector中其他任务的执行
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcRequest msg) throws Exception {
        try {
            if (msg.getHeartBeat()){
                logger.info("接收到客户端心跳包...");
                return;
            }
            logger.info("服务器接收到请求: {}", msg);
            Object result = requestHandler.handle(msg);
            //注意这里的通道是workGroup中的，而NettyServer中创建的是bossGroup的，不要混淆
            ChannelFuture future = ctx.writeAndFlush(RpcResponse.success(result, msg.getRequestId()));
            //当操作失败或者被取消了就关闭通道
            future.addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
        }finally {
            ReferenceCountUtil.release(msg);
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception{
        logger.error("处理过程调用时有错误发生：");
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleState state = ((IdleStateEvent) evt).state();
            if(state == IdleState.READER_IDLE){
                logger.info("长时间未收到心跳包，断开连接...");
                ctx.close();
            }
        }else{
            super.userEventTriggered(ctx, evt);
        }
    }
}
