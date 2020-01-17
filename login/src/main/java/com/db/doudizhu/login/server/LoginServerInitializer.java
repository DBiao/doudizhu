package com.db.doudizhu.login.server;


import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * date: 2020/1/17 9:58
 * author: DengBiao
 */
public class LoginServerInitializer extends ChannelInitializer<Channel> {

    @Override
    protected void initChannel(Channel ch) throws Exception {
        //websocket协议本身是基于http协议的，所以这边也要使用http解编码器
        ch.pipeline().addLast(new HttpServerCodec());
        //以块的方式来写的处理器
        ch.pipeline().addLast(new ChunkedWriteHandler());
        ch.pipeline().addLast(new HttpObjectAggregator(65536));
        ch.pipeline().addLast(new LoginServerHandle());
    }
}
