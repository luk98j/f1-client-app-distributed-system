package com.f1distributedsystem.f1clientapp.business.sender.packets;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;
import com.f1distributedsystem.f1clientapp.business.packet.data.CarDamageData;
import com.f1distributedsystem.f1clientapp.business.packet.impl.PacketCarDamageData;
import com.f1distributedsystem.f1clientapp.business.packet.impl.PacketEventData;
import com.f1distributedsystem.f1clientapp.dto.impl.CarDamageDataDto;
import com.f1distributedsystem.f1clientapp.dto.impl.CarDamageList;
import com.f1distributedsystem.f1clientapp.service.PostSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class PacketCarDamageSender implements PacketSenderInterface {
    private final static String URL = "damage";
    private PostSender postSender = new PostSender();

    @Override
    public void sendPacket(Packet packet, String uniqueId) {
        PacketCarDamageData packetCarDamageData = (PacketCarDamageData) packet;
        BigInteger sessionid = packetCarDamageData.getHeader().getSessionUid();
        List<CarDamageData> carDamageDataList = packetCarDamageData.getCarStatusData();
        List<CarDamageDataDto> carDamageDataDtoList = new ArrayList<>();
        int i = 0;
        for(CarDamageData carDamageData: carDamageDataList){
            CarDamageDataDto carDamageDataDto = new CarDamageDataDto(
                    i,
                    carDamageData.getTyresWear(),
                    carDamageData.getTyresDamage(),
                    carDamageData.getBrakesDamage(),
                    carDamageData.getFrontLeftWingDamage(),
                    carDamageData.getFrontRightWingDamage(),
                    carDamageData.getRearWingDamage(),
                    carDamageData.getFloorDamage(),
                    carDamageData.getDiffuserDamage(),
                    carDamageData.getSidepodDamage()
            );
            carDamageDataDtoList.add(carDamageDataDto);
            i+=1;
        }
        postSender.sendPost(URL+"/post-damage", new CarDamageList(sessionid, carDamageDataDtoList), uniqueId);
    }
}
