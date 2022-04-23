package com.f1distributedsystem.f1clientapp.business.telemetry;

import com.f1distributedsystem.f1clientapp.business.packet.PacketDecoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;


@Component
@Slf4j
public class TelemetryMonitor {
    private int port;
    private EventLoopGroup group;
    private Bootstrap bootstrap;
    private InetSocketAddress inetSocketAddress = new InetSocketAddress(20779);
    public TelemetryMonitor(){

    }

    public void run() {
        this.group = new NioEventLoopGroup();
        this.bootstrap = new Bootstrap();
        this.bootstrap.group(group)
                .channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST, true)
                .handler( new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel)
                            throws Exception {
                        ChannelPipeline pipeline = channel.pipeline();
                        pipeline.addLast(new TelemetryEventDecoder(new PacketDecoder()));
                        pipeline.addLast(new TelemetryEventHandler());
                    }
                } )
                .localAddress(inetSocketAddress);
    }

    public Channel bind() {
        return this.bootstrap.bind().syncUninterruptibly().channel();
    }

    public void stop() {
        this.group.shutdownGracefully();
    }

}
