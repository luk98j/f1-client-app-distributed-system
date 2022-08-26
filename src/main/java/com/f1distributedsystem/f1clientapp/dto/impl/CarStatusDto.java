package com.f1distributedsystem.f1clientapp.dto.impl;

import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.ActualTyreCompound;
import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.VehicleFiaFlag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CarStatusDto {
    private int carIndex;
    private ActualTyreCompound actualTyreCompound;
    private short tyresAgeLaps;
    private float ersStoreEnergy;
    private float fuelInTank;
    private VehicleFiaFlag vehicleFiaFlag;
}
