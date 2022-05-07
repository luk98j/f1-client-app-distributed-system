package com.f1distributedsystem.f1clientapp.business.packet.data;

import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.SurfaceType;
import com.f1distributedsystem.f1clientapp.utilities.Const;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class CarTelemetryData {
    public static final int SIZE = 58;

    private int speed;
    private float throttle;
    private float steer;
    private float brake;
    private short clutch;
    private short gear;
    private int engineRPM;
    private short drs;
    private short revLightsPercent;
    private int revLightsBitValue;
    private int brakesTemperature[] = new int[Const.TYRES];
    private short tyresSurfaceTemperature[] = new short[Const.TYRES];
    private short tyresInnerTemperature[] = new short[Const.TYRES];
    private int engineTemperature;
    private float tyresPressure[] = new float[Const.TYRES];
    private SurfaceType surfaceType[] = new SurfaceType[Const.TYRES];

    public CarTelemetryData fill(ByteBuf buffer) {
        this.speed = buffer.readUnsignedShortLE();
        this.throttle = buffer.readFloatLE();
        this.steer = buffer.readFloatLE();
        this.brake = buffer.readFloatLE();
        this.clutch = buffer.readUnsignedByte();
        this.gear = buffer.readByte();
        this.engineRPM = buffer.readUnsignedShortLE();
        this.drs = buffer.readUnsignedByte();
        this.revLightsPercent = buffer.readUnsignedByte();
        this.revLightsBitValue = buffer.readUnsignedShortLE();
        for (int j = 0; j < Const.TYRES; j++) {
            this.brakesTemperature[j] = buffer.readUnsignedShortLE();
        }
        for (int j = 0; j < Const.TYRES; j++) {
            this.tyresSurfaceTemperature[j] = buffer.readUnsignedByte();
        }
        for (int j = 0; j < Const.TYRES; j++) {
            this.tyresInnerTemperature[j] = buffer.readUnsignedByte();
        }
        this.engineTemperature = buffer.readUnsignedShortLE();
        for (int j = 0; j < Const.TYRES; j++) {
            this.tyresPressure[j] = buffer.readFloatLE();
        }
        for (int j = 0; j < Const.TYRES; j++) {
            this.surfaceType[j] = SurfaceType.valueOf(buffer.readUnsignedByte());
        }
        return this;
    }

    @Override
    public String toString() {
        return "CarTelemetryData[speed=" + this.speed +
                ",throttle=" + this.throttle +
                ",steer=" + this.steer +
                ",brake=" + this.brake +
                ",clutch=" + this.clutch +
                ",gear=" + this.gear +
                ",engineRPM=" + this.engineRPM +
                ",drs=" + this.drs +
                ",revLightsPercent=" + this.revLightsPercent +
                ",revLightsBitValue=" + this.revLightsBitValue +
                ",brakesTemperature=" + Arrays.toString(this.brakesTemperature) +
                ",tyresSurfaceTemperature=" + Arrays.toString(this.tyresSurfaceTemperature) +
                ",tyresInnerTemperature=" + Arrays.toString(this.tyresInnerTemperature) +
                ",engineTemperature=" + this.engineTemperature +
                ",tyresPressure=" + Arrays.toString(this.tyresPressure) +
                ",surfaceType=" + Arrays.toString(this.surfaceType) +
                "]";
    }
}
