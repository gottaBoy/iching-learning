package com.gottaboy.iching.mybatis.rpc.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

@Slf4j(topic = "server-log")
public class NettyServer {
    private RpcInvokeHandler rpcInvokeHandler;

    public NettyServer(List<ServiceConfig> serviceConfigs, Map<String, Method> id2MethodMap) {
        this.rpcInvokeHandler = new RpcInvokeHandler(serviceConfigs, id2MethodMap);
    }

    public void init(Integer port) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ChannelInitializer() {
                    @Override
                    protected void initChannel(Channel ch) {
                        //设置根据分隔符“$$”来拆分消息
                        ByteBuf delimiter = Unpooled.copiedBuffer("$$", Charset.forName("UTF-8"));
                        ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024 * 1024, delimiter));
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast().addLast(rpcInvokeHandler);
                    }
                });
        b.bind(port).sync();
        log.info("启动NettyServer成功,端口号为："+port);
    }
}
