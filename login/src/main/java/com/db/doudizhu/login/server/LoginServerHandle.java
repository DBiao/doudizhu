package com.db.doudizhu.login.server;

import com.db.doudizhu.common.protobuf.GameProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * date: 2020/1/17 9:58
 * author: DengBiao
 */
public class LoginServerHandle extends SimpleChannelInboundHandler<GameProto.Message> {
    private static Logger logger = LoggerFactory.getLogger(LoginServerHandle.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GameProto.Message msg) throws Exception {

    }
}
