package com.f1distributedsystem.f1clientapp.business.packet;

import com.f1distributedsystem.f1clientapp.business.packet.data.FinalClassificationData;
import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.PacketId;
import com.f1distributedsystem.f1clientapp.business.packet.impl.*;
import io.netty.buffer.ByteBuf;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PacketDecoder {

    public PacketDecoder() {
    }

    public boolean checkPacket(ByteBuf byteBuf){
        Packet packet = getCorrectPacketType(byteBuf);
        return packet != null;
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
            case CAR_SETUPS:
            case LOBBY_INFO:
            case SESSION_HISTORY:
                return null;
            case SESSION:
                return new PacketSessionData();
            case LAP_DATA:
                return new PacketLapData();
            case EVENT:
                return new PacketEventData();
            case CAR_TELEMETRY:
                return new PacketCarTelemetryData();
            case CAR_STATUS:
                return new PacketCarStatusData();
            case FINAL_CLASSIFICATION:
                return new FinalClassificationData();
            case CAR_DAMAGE:
                return new PacketCarDamageData();
            case PARTICIPANTS:
                return new PacketParticipantsData();
            default:
                throw new IllegalArgumentException("PacketId=" + packetId + " not supported");

        }
    }

    private PacketId getPacketId(ByteBuf buffer) {
        return PacketId.valueOf(buffer.getUnsignedByte(PacketHeader.PACKET_ID_OFFSET));
    }
}
