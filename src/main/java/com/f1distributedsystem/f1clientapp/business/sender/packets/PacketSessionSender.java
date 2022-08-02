package com.f1distributedsystem.f1clientapp.business.sender.packets;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;
import com.f1distributedsystem.f1clientapp.business.packet.impl.PacketSessionData;
import com.f1distributedsystem.f1clientapp.dto.impl.PacketSessionDto;
import com.f1distributedsystem.f1clientapp.dto.impl.ParticipantListDto;
import com.f1distributedsystem.f1clientapp.service.PostSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class PacketSessionSender implements PacketSenderInterface{

    @Autowired
    private PostSender postSender;
    private final static String URL = "session-data";

    @Override
    public void sendPacket(Packet packet, String uniqueId) {
        PacketSessionData packetSessionData = (PacketSessionData) packet;
        BigInteger sessionid = packetSessionData.getHeader().getSessionUid();
        PacketSessionDto packetSessionDto = new PacketSessionDto(
                sessionid,
                packetSessionData.getWeather(),
                packetSessionData.getTrackTemperature(),
                packetSessionData.getAirTemperature(),
                packetSessionData.getTotalLaps(),
                packetSessionData.getSessionType(),
                packetSessionData.getTrackId(),
                packetSessionData.getPitSpeedLimit(),
                packetSessionData.getNumMarshalZones(),
                packetSessionData.getMarshalZones(),
                packetSessionData.getSafetyCarStatus(),
                packetSessionData.getNetworkGame(),
                packetSessionData.getNumWeatherForecastSamples(),
                packetSessionData.getWeatherForecastSamples()
        );
        postSender.sendPost(URL+"/post-session", packetSessionDto, uniqueId);
    }
}
