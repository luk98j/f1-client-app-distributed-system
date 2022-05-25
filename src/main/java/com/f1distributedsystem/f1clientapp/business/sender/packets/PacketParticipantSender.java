package com.f1distributedsystem.f1clientapp.business.sender.packets;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;
import com.f1distributedsystem.f1clientapp.business.packet.data.ParticipantData;
import com.f1distributedsystem.f1clientapp.business.packet.impl.PacketParticipantsData;
import com.f1distributedsystem.f1clientapp.dto.impl.LapDataList;
import com.f1distributedsystem.f1clientapp.dto.impl.ParticipantDto;
import com.f1distributedsystem.f1clientapp.dto.impl.ParticipantListDto;
import com.f1distributedsystem.f1clientapp.service.PostSender;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PacketParticipantSender implements PacketSenderInterface{

    private PostSender postSender = new PostSender();
    private final static String URL = "participant-data";

    @Override
    public void sendPacket(Packet packet, String uniqueId) throws IOException, InterruptedException {
        PacketParticipantsData packetParticipantsData = (PacketParticipantsData) packet;
        BigInteger sessionid = packetParticipantsData.getHeader().getSessionUid();
        List<ParticipantDto> participantDtoList = new ArrayList<>();
        List<ParticipantData> participantDataList = packetParticipantsData.getParticipants();
        for(ParticipantData participantData : participantDataList){
            ParticipantDto participantDto = new ParticipantDto(
                    participantData.getDriverId(),
                    participantData.getNetworkId(),
                    participantData.getName(),
                    participantData.getYourTelemetry()
            );
            participantDtoList.add(participantDto);
        }
        postSender.sendPost(URL+"/post-participant", new ParticipantListDto(sessionid, participantDtoList), uniqueId);
    }
}
