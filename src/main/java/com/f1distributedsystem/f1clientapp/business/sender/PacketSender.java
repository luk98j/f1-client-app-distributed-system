package com.f1distributedsystem.f1clientapp.business.sender;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;
import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.PacketId;
import com.f1distributedsystem.f1clientapp.business.sender.packets.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public PacketSender(PacketEventSender packetEventSender, PacketCarDamageSender packetCarDamageSender, PacketCarStatusSender packetCarStatusSender, PacketCarTelemetrySender packetCarTelemetrySender, PacketFinalClassificationSender packetFinalClassificationSender, PacketLapDataSender packetLapDataSender, PacketParticipantSender packetParticipantSender, PacketSessionSender packetSessionSender) {
        this.packetEventSender = packetEventSender;
        this.packetCarDamageSender = packetCarDamageSender;
        this.packetCarStatusSender = packetCarStatusSender;
        this.packetCarTelemetrySender = packetCarTelemetrySender;
        this.packetFinalClassificationSender = packetFinalClassificationSender;
        this.packetLapDataSender = packetLapDataSender;
        this.packetParticipantSender = packetParticipantSender;
        this.packetSessionSender = packetSessionSender;
    }

    public void splitPackages(Packet packet, String uniqueId) throws IOException, InterruptedException {
        PacketId packetId = packet.getHeader().getPacketId();
        switch (packetId){
            case SESSION:
                packetSessionSender.sendPacket(packet,uniqueId);
                break;
            case LAP_DATA:
                packetLapDataSender.sendPacket(packet,uniqueId);
                break;
            case EVENT:
                packetEventSender.sendPacket(packet,uniqueId);
                break;
            case CAR_TELEMETRY:
                packetCarTelemetrySender.sendPacket(packet, uniqueId);
                break;
            case CAR_STATUS:
                packetCarStatusSender.sendPacket(packet, uniqueId);
                break;
            case FINAL_CLASSIFICATION:
                packetFinalClassificationSender.sendPacket(packet, uniqueId);
                break;
            case CAR_DAMAGE:
                packetCarDamageSender.sendPacket(packet, uniqueId);
                break;
            case PARTICIPANTS:
                packetParticipantSender.sendPacket(packet, uniqueId);
                break;
        }
    }

}
