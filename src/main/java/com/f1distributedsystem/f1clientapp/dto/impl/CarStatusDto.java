package com.f1distributedsystem.f1clientapp.dto.impl;

import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.ActualTyreCompound;
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
}
