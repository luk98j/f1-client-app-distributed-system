package com.f1distributedsystem.f1clientapp.business.telemetry;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;
import com.f1distributedsystem.f1clientapp.business.packet.PacketDecoder;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Configurable
public class TelemetryEventDecoder extends MessageToMessageDecoder<DatagramPacket> {

    private PacketDecoder packetDecoder;

    @Autowired
    public TelemetryEventDecoder(PacketDecoder packetDecoder) {
        this.packetDecoder = packetDecoder;
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List<Object> list) throws Exception {
        ByteBuf buffer = datagramPacket.content();
        if(packetDecoder.decode(buffer)!=null){
            Packet packet = packetDecoder.decode(buffer);
            log.info(packet.toString());
            list.add(packet);
        }

    }
}
