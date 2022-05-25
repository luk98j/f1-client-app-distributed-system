package com.f1distributedsystem.f1clientapp.business.sender.packets;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;
import com.f1distributedsystem.f1clientapp.business.packet.data.LapData;
import com.f1distributedsystem.f1clientapp.business.packet.impl.PacketLapData;
import com.f1distributedsystem.f1clientapp.dto.impl.FinalClasificationList;
import com.f1distributedsystem.f1clientapp.dto.impl.LapDataDto;
import com.f1distributedsystem.f1clientapp.dto.impl.LapDataList;
import com.f1distributedsystem.f1clientapp.service.PostSender;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PacketLapDataSender implements PacketSenderInterface{
    private PostSender postSender = new PostSender();
    private final static String URL = "lap-data";
    @Override
    public void sendPacket(Packet packet, String uniqueId) throws IOException, InterruptedException {
        PacketLapData packetLapData = (PacketLapData) packet;
        BigInteger sessionid = packetLapData.getHeader().getSessionUid();
        List<LapDataDto> lapDataDtoList = new ArrayList<>();
        List<LapData> lapDataList = packetLapData.getLapData();
        for(LapData lapData: lapDataList){
            LapDataDto lapDataDto = new LapDataDto(
                    lapData.getLastLapTime(),
                    lapData.getCurrentLapTime(),
                    lapData.getSector1TimeInMS(),
                    lapData.getSector2TimeInMS(),
                    lapData.getCarPosition(),
                    lapData.getCurrentLapNum(),
                    lapData.getPitStatus(),
                    lapData.getSector(),
                    lapData.getCurrentLapInvalid(),
                    lapData.getPenalties(),
                    lapData.getWarnings(),
                    lapData.getNumUnservedDriveThroughPens(),
                    lapData.getNumUnservedStopGoPens(),
                    lapData.getDriverStatus(),
                    lapData.getResultStatus(),
                    lapData.getPitLaneTimerActive(),
                    lapData.getPitLaneTimeInLaneInMS(),
                    lapData.getPitStopTimerInMS(),
                    lapData.getPitStopShouldServePen()
            );
            lapDataDtoList.add(lapDataDto);
        }
        postSender.sendPost(URL+"/post-lap", new LapDataList(sessionid, lapDataDtoList), uniqueId);
    }
}
