package com.f1distributedsystem.f1clientapp.business.telemetry;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelemetryEventHandler extends SimpleChannelInboundHandler<Packet> {

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext,
                                Throwable cause) throws Exception {
        cause.printStackTrace();
        channelHandlerContext.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Packet packet) throws Exception {
        log.info("Packet: {}, PacketId: {}, SessionId: {}, SessionTime: {}",
                packet.getHeader().getFrameIdentifier(),
                packet.getHeader().getPacketId(),
                packet.getHeader().getSessionUid(),
                packet.getHeader().getSessionTime());
    }
}
