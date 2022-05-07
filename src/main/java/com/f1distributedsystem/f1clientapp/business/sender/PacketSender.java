package com.f1distributedsystem.f1clientapp.business.sender;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;
import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.PacketId;
import com.f1distributedsystem.f1clientapp.business.sender.packets.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PacketSender {

    private PacketEventSender packetEventSender;
    private PacketCarDamageSender packetCarDamageSender;
    private PacketCarStatusSender packetCarStatusSender;
    private PacketCarTelemetrySender packetCarTelemetrySender;
    private PacketFinalClassificationSender packetFinalClassificationSender;
    private PacketLapDataSender packetLapDataSender;
    private PacketParticipantSender packetParticipantSender;
    private PacketSessionSender packetSessionSender;

    public PacketSender() {
        packetEventSender = new PacketEventSender();
    }

    public void splitPackages(Packet packet) throws IOException, InterruptedException {
        PacketId packetId = packet.getHeader().getPacketId();
        switch (packetId){
            case SESSION:
                packetSessionSender.sendPacket(packet);
                break;
            case LAP_DATA:
                packetLapDataSender.sendPacket(packet);
                break;
            case EVENT:
                packetEventSender.sendPacket(packet);
                break;
            case CAR_TELEMETRY:
                packetCarTelemetrySender.sendPacket(packet);
                break;
            case CAR_STATUS:
                packetCarStatusSender.sendPacket(packet);
                break;
            case FINAL_CLASSIFICATION:
                packetFinalClassificationSender.sendPacket(packet);
                break;
            case CAR_DAMAGE:
                packetCarDamageSender.sendPacket(packet);
                break;
            case PARTICIPANTS:
                packetParticipantSender.sendPacket(packet);
                break;
        }
    }

}
