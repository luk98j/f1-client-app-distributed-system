package com.f1distributedsystem.f1clientapp.business.sender.packets;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;
import com.f1distributedsystem.f1clientapp.business.packet.data.CarStatusData;
import com.f1distributedsystem.f1clientapp.business.packet.data.CarTelemetryData;
import com.f1distributedsystem.f1clientapp.business.packet.impl.PacketCarTelemetryData;
import com.f1distributedsystem.f1clientapp.dto.impl.CarStatusDto;
import com.f1distributedsystem.f1clientapp.dto.impl.CarStatusList;
import com.f1distributedsystem.f1clientapp.dto.impl.CarTelemetryDto;
import com.f1distributedsystem.f1clientapp.dto.impl.CarTelemetryList;
import com.f1distributedsystem.f1clientapp.service.PostSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class PacketCarTelemetrySender implements PacketSenderInterface{
    @Autowired
    private PostSender postSender;
    private final static String URL = "car-telemetry";

    @Override
    public void sendPacket(Packet packet, String uniqueId) {
        PacketCarTelemetryData carTelemetryData = (PacketCarTelemetryData) packet;
        BigInteger sessionid = carTelemetryData.getHeader().getSessionUid();
        List<CarTelemetryData> carStatusDataList = carTelemetryData.getCarTelemetryData();
        List<CarTelemetryDto> carStatusDtoList = new ArrayList<>();
        int i = 0;
        for(CarTelemetryData carTelemetryData1: carStatusDataList){
            CarTelemetryDto carStatusDto = new CarTelemetryDto(
                    i,
                    carTelemetryData1.getDrs(),
                    carTelemetryData1.getBrakesTemperature(),
                    carTelemetryData1.getTyresSurfaceTemperature()
            );
            carStatusDtoList.add(carStatusDto);
            i+=1;
        }
        postSender.sendPost(URL+"/post-telemetry", new CarTelemetryList(sessionid, carStatusDtoList), uniqueId);
    }
}
