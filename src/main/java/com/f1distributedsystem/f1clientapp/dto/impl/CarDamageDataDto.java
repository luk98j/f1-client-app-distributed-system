package com.f1distributedsystem.f1clientapp.dto.impl;

import com.f1distributedsystem.f1clientapp.dto.MainDto;
import com.f1distributedsystem.f1clientapp.utilities.Const;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CarDamageDataDto extends MainDto {
    private int carIndex;
    private float tyresWear[] = new float[Const.TYRES];
    private short tyresDamage[] = new short[Const.TYRES];
    private short brakesDamage[] = new short[Const.TYRES];
    private short frontLeftWingDamage;
    private short frontRightWingDamage;
    private short rearWingDamage;
    private short floorDamage;
    private short diffuserDamage;
    private short sidepodDamage;
}
