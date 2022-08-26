package com.f1distributedsystem.f1clientapp.business.packet.data;

import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.*;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class CarStatusData {
    private TractionControl tractionControl;
    private short antiLockBrakes;
    private FuelMix fuelMix;
    private short frontBrakeBias;
    private short pitLimiterStatus;
    private float fuelInTank;
    private float fuelCapacity;
    private float fuelRemainingLaps;
    private int maxRPM;
    private int idleRPM;
    private short maxGears;
    private DrsAllowed drsAllowed;
    private int drsActivationDistance;
    private ActualTyreCompound actualTyreCompound;
    private VisualTyreCompound visualTyreCompound;
    private short tyresAgeLaps;
    private VehicleFiaFlag vehicleFiaFlags;
    private float ersStoreEnergy;
    private ErsDeployMode ersDeployMode;
    private float ersHarvestedThisLapMGUK;
    private float ersHarvestedThisLapMGUH;
    private float ersDeployedThisLap;
    private short networkPaused;

    public CarStatusData fill(ByteBuf buffer) {
        this.tractionControl = TractionControl.valueOf(buffer.readUnsignedByte());
        this.antiLockBrakes = buffer.readUnsignedByte();
        this.fuelMix = FuelMix.valueOf(buffer.readUnsignedByte());
        this.frontBrakeBias = buffer.readUnsignedByte();
        this.pitLimiterStatus = buffer.readUnsignedByte();
        this.fuelInTank = buffer.readFloatLE();
        this.fuelCapacity = buffer.readFloatLE();
        this.fuelRemainingLaps = buffer.readFloatLE();
        this.maxRPM = buffer.readUnsignedShortLE();
        this.idleRPM = buffer.readUnsignedShortLE();
        this.maxGears = buffer.readUnsignedByte();
        this.drsAllowed = DrsAllowed.valueOf(buffer.readUnsignedByte());
        this.drsActivationDistance = buffer.readUnsignedShortLE();
        this.actualTyreCompound = ActualTyreCompound.valueOf(buffer.readUnsignedByte());
        this.visualTyreCompound = VisualTyreCompound.valueOf(buffer.readUnsignedByte());
        this.tyresAgeLaps = buffer.readUnsignedByte();
        this.vehicleFiaFlags = VehicleFiaFlag.valueOf(buffer.readByte());
        this.ersStoreEnergy = buffer.readFloatLE();
        this.ersDeployMode = ErsDeployMode.valueOf(buffer.readUnsignedByte());
        this.ersHarvestedThisLapMGUK = buffer.readFloatLE();
        this.ersHarvestedThisLapMGUH = buffer.readFloatLE();
        this.ersDeployedThisLap = buffer.readFloatLE();
        this.networkPaused = buffer.readUnsignedByte();
        return this;
    }

    @Override
    public String toString() {
        return "CarStatusData[tractionControl=" + this.tractionControl +
                ",antiLockBrakes=" + this.antiLockBrakes +
                ",fuelMix=" + this.fuelMix +
                ",frontBrakeBias=" + this.frontBrakeBias +
                ",pitLimiterStatus=" + this.pitLimiterStatus +
                ",fuelInTank=" + this.fuelInTank +
                ",fuelCapacity=" + this.fuelCapacity +
                ",fuelRemainingLaps=" + this.fuelRemainingLaps +
                ",maxRPM=" + this.maxRPM +
                ",idleRPM=" + this.idleRPM +
                ",maxGears=" + this.maxGears +
                ",drsAllowed=" + this.drsAllowed +
                ",drsActivationDistance=" + this.drsActivationDistance +
                ",actualTyreCompound=" + this.actualTyreCompound +
                ",visualTyreCompound=" + this.visualTyreCompound +
                ",tyresAgeLaps=" + this.tyresAgeLaps +
                ",vehicleFiaFlags=" + this.vehicleFiaFlags +
                ",ersStoreEnergy=" + this.ersStoreEnergy +
                ",ersDeployMode=" + this.ersDeployMode +
                ",ersHarvestedThisLapMGUK=" + this.ersHarvestedThisLapMGUK +
                ",ersHarvestedThisLapMGUH=" + this.ersHarvestedThisLapMGUH +
                ",ersDeployedThisLap=" + this.ersDeployedThisLap +
                "]";
    }
}
