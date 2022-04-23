package com.f1distributedsystem.f1clientapp.business.packet;

import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.PacketId;
import com.f1distributedsystem.f1clientapp.business.packet.impl.PacketLapData;
import com.f1distributedsystem.f1clientapp.business.packet.impl.PacketSessionData;
import io.netty.buffer.ByteBuf;
import org.springframework.stereotype.Component;

@Component
public class PacketDecoder {

    public PacketDecoder() {
    }

    public Packet decode(ByteBuf byteBuf){
        Packet packet = getCorrectPacketType(byteBuf);
        if(packet != null){
            return packet.fill(byteBuf);
        } else {
            return null;
        }
    }

    private Packet getCorrectPacketType(ByteBuf byteBuf){
        PacketId packetId = getPacketId(byteBuf);
        switch (packetId) {
            case MOTION:
                return null;
            case SESSION:
//                return new PacketSessionData();
                return null;
            case LAP_DATA:
                return new PacketLapData();
            case EVENT:
                return null;
            case PARTICIPANTS:
                return null;
            case CAR_SETUPS:
                return null;
            case CAR_TELEMETRY:
                return null;
            case CAR_STATUS:
                return null;
            case FINAL_CLASSIFICATION:
                return null;
            case LOBBY_INFO:
                return null;
            case CAR_DAMAGE:
                return null;
            case SESSION_HISTORY:
                return null;
            default:
                throw new IllegalArgumentException("PacketId=" + packetId + " not supported");

        }
    }

    private PacketId getPacketId(ByteBuf buffer) {
        return PacketId.valueOf(buffer.getUnsignedByte(PacketHeader.PACKET_ID_OFFSET));
    }
}
