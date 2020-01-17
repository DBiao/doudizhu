package com.db.doudizhu.server.server;

import com.db.doudizhu.common.protobuf.GameProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * date: 2020/1/16 17:14
 * author: DengBiao
 */
public class GameServerHandle extends SimpleChannelInboundHandler<GameProto.Message> {
    private static Logger logger = LoggerFactory.getLogger(GameServerHandle.class);

    /**
     * 接收消息
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GameProto.Message msg) throws Exception {

    }

    /**
     * 取消绑定
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

    }

    /**
     * 异常处理
     *
     * @param ctx
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {

    }
}
