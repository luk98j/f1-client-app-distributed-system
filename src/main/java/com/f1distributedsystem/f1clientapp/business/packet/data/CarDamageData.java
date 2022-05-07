package com.f1distributedsystem.f1clientapp.business.packet.data;

import com.f1distributedsystem.f1clientapp.utilities.Const;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class CarDamageData {
    //private short tyreStintsActual[] = new short[Const.TYRE_STINTS];
    private float tyresWear[] = new float[Const.TYRES];
    private short tyresDamage[] = new short[Const.TYRES];
    private short brakesDamage[] = new short[Const.TYRES];
    private short frontLeftWingDamage;
    private short frontRightWingDamage;
    private short rearWingDamage;
    private short floorDamage;
    private short diffuserDamage;
    private short sidepodDamage;
    private short drsFault;
    private short gearBoxDamage;
    private short engineDamage;
    private short engineMGUHWear;
    private short engineESWear;
    private short engineCEWear;
    private short engineICEWear;
    private short engineMGUKWear;
    private short engineTCWear;

    public CarDamageData fill(ByteBuf buffer){
        for (int j = 0; j < Const.TYRES; j++) {
            this.tyresWear[j] = buffer.readFloatLE();
        }
        for (int j = 0; j < Const.TYRES; j++) {
            this.tyresDamage[j] = buffer.readUnsignedByte();
        }
        for (int j = 0; j < Const.TYRES; j++) {
            this.brakesDamage[j] = buffer.readUnsignedByte();
        }
        this.frontLeftWingDamage = buffer.readUnsignedByte();
        this.frontRightWingDamage = buffer.readUnsignedByte();
        this.rearWingDamage = buffer.readUnsignedByte();
        this.floorDamage = buffer.readUnsignedByte();
        this.diffuserDamage = buffer.readUnsignedByte();
        this.sidepodDamage = buffer.readUnsignedByte();
        this.drsFault = buffer.readUnsignedByte();
        this.gearBoxDamage = buffer.readUnsignedByte();
        this.engineDamage = buffer.readUnsignedByte();
        this.engineMGUHWear = buffer.readUnsignedByte();
        this.engineESWear = buffer.readUnsignedByte();
        this.engineCEWear = buffer.readUnsignedByte();
        this.engineICEWear = buffer.readUnsignedByte();
        this.engineMGUKWear = buffer.readUnsignedByte();
        this.engineTCWear = buffer.readUnsignedByte();
        return this;
    }

    @Override
    public String toString() {
        return "CarDamageData[tyresWear=" + Arrays.toString(this.tyresWear) +
                ",tyresDamage=" + Arrays.toString(this.tyresDamage) +
                ",brakesDamage=" + Arrays.toString(this.brakesDamage) +
                ",frontLeftWingDamage=" + this.frontLeftWingDamage +
                ",frontRightWingDamage=" + this.frontRightWingDamage +
                ",rearWingDamage=" + this.rearWingDamage +
                ",floorDamage=" + this.floorDamage +
                ",diffuserDamage=" + this.diffuserDamage +
                ",sidepodDamage=" + this.sidepodDamage +
                ",drsFault=" + this.drsFault +
                ",gearBoxDamage=" + this.gearBoxDamage +
                ",engineDamage=" + this.engineDamage +
                ",engineMGUHWear=" + this.engineMGUHWear +
                ",engineESWear=" + this.engineESWear +
                ",engineCEWear=" + this.engineCEWear +
                ",engineICEWear=" + this.engineICEWear +
                ",engineMGUKWear=" + this.engineMGUKWear +
                ",engineTCWear=" + this.engineTCWear +
                "]";
    }

}
