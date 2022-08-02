package com.f1distributedsystem.f1clientapp.business.sender.packets;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;
import com.f1distributedsystem.f1clientapp.business.packet.data.CarStatusData;
import com.f1distributedsystem.f1clientapp.business.packet.impl.PacketCarStatusData;
import com.f1distributedsystem.f1clientapp.dto.impl.CarDamageList;
import com.f1distributedsystem.f1clientapp.dto.impl.CarStatusDto;
import com.f1distributedsystem.f1clientapp.dto.impl.CarStatusList;
import com.f1distributedsystem.f1clientapp.service.PostSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class PacketCarStatusSender implements PacketSenderInterface{
    @Autowired
    private PostSender postSender;
    private final static String URL = "car-status";

    @Override
    public void sendPacket(Packet packet, String uniqueId) {
        PacketCarStatusData packetCarStatusData = (PacketCarStatusData) packet;
        BigInteger sessionid = packetCarStatusData.getHeader().getSessionUid();
        List<CarStatusData> carStatusDataList = packetCarStatusData.getCarStatusData();
        List<CarStatusDto> carStatusDtoList = new ArrayList<>();
        int i = 0;
        for(CarStatusData carStatusData: carStatusDataList){
            CarStatusDto carStatusDto = new CarStatusDto(
                    i,
                    carStatusData.getActualTyreCompound(),
                    carStatusData.getTyresAgeLaps(),
                    carStatusData.getErsStoreEnergy()
            );
            carStatusDtoList.add(carStatusDto);
            i=+1;
        }
        postSender.sendPost(URL+"/post-status", new CarStatusList(sessionid, carStatusDtoList), uniqueId);
    }
}
