package com.db.doudizhu.server.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * date: 2020/1/16 17:12
 * author: DengBiao
 */
public class GameServerInitializer extends ChannelInitializer<Channel> {

    @Override
    protected void initChannel(Channel ch) throws Exception {
        //websocket协议本身是基于http协议的，所以这边也要使用http解编码器
        ch.pipeline().addLast(new HttpServerCodec());
        // 把多个消息转换为一个单一的FullHttpRequest或是FullHttpResponse，
        // 原因是HTTP解码器会在每个HTTP消息中生成多个消息对象HttpRequest/HttpResponse,HttpContent,LastHttpContent
        ch.pipeline().addLast(new HttpObjectAggregator(65536));
        // 压缩
        ch.pipeline().addLast(new WebSocketServerCompressionHandler());
        ch.pipeline().addLast(new GameServerHandle());
    }
}
