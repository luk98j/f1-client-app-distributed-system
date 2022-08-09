package com.f1distributedsystem.f1clientapp.business.sender.packets;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;
import com.f1distributedsystem.f1clientapp.business.packet.data.FinalClassificationData;
import com.f1distributedsystem.f1clientapp.business.packet.impl.PacketFinalClassificationData;
import com.f1distributedsystem.f1clientapp.dto.impl.CarFinalClasificationDto;
import com.f1distributedsystem.f1clientapp.dto.impl.CarTelemetryList;
import com.f1distributedsystem.f1clientapp.dto.impl.FinalClasificationList;
import com.f1distributedsystem.f1clientapp.service.PostSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class PacketFinalClassificationSender implements PacketSenderInterface{
    @Autowired
    private PostSender postSender;
    private final static String URL = "final-clasification";
    @Override
    public void sendPacket(Packet packet, String uniqueId) throws IOException, InterruptedException {
        PacketFinalClassificationData packetFinalClassificationSender = (PacketFinalClassificationData) packet;
        BigInteger sessionid = packetFinalClassificationSender.getHeader().getSessionUid();
        List<CarFinalClasificationDto> carFinalClasificationDtoList =  new ArrayList<>();
        List<FinalClassificationData> classificationData = packetFinalClassificationSender.getFinalClassificationData();
        int i = 0;
        for(FinalClassificationData f: classificationData){
            CarFinalClasificationDto dto = new CarFinalClasificationDto(
                    i,
                    f.getPosition(),
                    f.getNumLaps(),
                    f.getGridPosition(),
                    f.getPoints(),
                    f.getNumPitStops(),
                    f.getResultStatus(),
                    f.getBestLapTime(),
                    f.getTotalRaceTime(),
                    f.getPenaltiesTime(),
                    f.getNumPenalties(),
                    f.getNumTyreStints()
                    );
            carFinalClasificationDtoList.add(dto);
            i+=1;
        }
        postSender.sendPost(URL+"/post-clasification", new FinalClasificationList(sessionid, carFinalClasificationDtoList), uniqueId);

    }
}
