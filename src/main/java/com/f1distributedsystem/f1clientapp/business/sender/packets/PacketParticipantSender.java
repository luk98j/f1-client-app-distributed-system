package com.f1distributedsystem.f1clientapp.business.sender.packets;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;
import com.f1distributedsystem.f1clientapp.business.packet.data.ParticipantData;
import com.f1distributedsystem.f1clientapp.business.packet.impl.PacketParticipantsData;
import com.f1distributedsystem.f1clientapp.dto.impl.LapDataList;
import com.f1distributedsystem.f1clientapp.dto.impl.ParticipantDto;
import com.f1distributedsystem.f1clientapp.dto.impl.ParticipantListDto;
import com.f1distributedsystem.f1clientapp.service.PostSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class PacketParticipantSender implements PacketSenderInterface{

    @Autowired
    private PostSender postSender;
    private final static String URL = "participant-data";

    @Override
    public void sendPacket(Packet packet, String uniqueId) throws IOException, InterruptedException {
        PacketParticipantsData packetParticipantsData = (PacketParticipantsData) packet;
        BigInteger sessionid = packetParticipantsData.getHeader().getSessionUid();
        List<ParticipantDto> participantDtoList = new ArrayList<>();
        List<ParticipantData> participantDataList = packetParticipantsData.getParticipants();
        int i = 0;
        for(ParticipantData participantData : participantDataList){
            ParticipantDto participantDto = new ParticipantDto(
                    i,
                    participantData.getDriverId(),
                    participantData.getNetworkId(),
                    participantData.getName(),
                    participantData.getYourTelemetry()
            );
            participantDtoList.add(participantDto);
            i+=1;
        }
        postSender.sendPost(URL+"/post-participant", new ParticipantListDto(sessionid, participantDtoList), uniqueId);
    }
}
