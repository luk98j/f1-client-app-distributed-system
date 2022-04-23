package com.f1distributedsystem.f1clientapp.business.packet.data;

import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.*;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LapData {
    public static final int SIZE = 49;

    private float lastLapTime;
    private float currentLapTime;
    private int sector1TimeInMS;
    private int sector2TimeInMS;
    private float lapDistance;
    private float totalDistance;
    private float safetyCarDelta;
    private short carPosition;
    private short currentLapNum;
    private PitStatus pitStatus;
    private Sector sector;
    private short currentLapInvalid;
    private short penalties;
    private short warnings;
    private short numUnservedDriveThroughPens;
    private short numUnservedStopGoPens;
    private short gridPosition;
    private DriverStatus driverStatus;
    private ResultStatus resultStatus;
    private PitLaneTimerActive pitLaneTimerActive;
    private float pitLaneTimeInLaneInMS;
    private float pitStopTimerInMS;
    private float pitStopShouldServePen;

    public LapData fill(ByteBuf buffer) {
        this.lastLapTime = buffer.readFloatLE();
        this.currentLapTime = buffer.readFloatLE();
        this.sector1TimeInMS = buffer.readUnsignedShortLE();
        this.sector2TimeInMS = buffer.readUnsignedShortLE();
        this.lapDistance = buffer.readFloatLE();
        this.totalDistance = buffer.readFloatLE();
        this.safetyCarDelta = buffer.readFloatLE();
        this.carPosition = buffer.readUnsignedByte();
        this.currentLapNum = buffer.readUnsignedByte();
        this.pitStatus = PitStatus.valueOf(buffer.readUnsignedByte());
        this.sector = Sector.valueOf(buffer.readUnsignedByte());
        this.currentLapInvalid = buffer.readUnsignedByte();
        this.penalties = buffer.readUnsignedByte();
        this.warnings = buffer.readUnsignedByte();
        this.gridPosition = buffer.readUnsignedByte();
        this.driverStatus = DriverStatus.valueOf(buffer.readUnsignedByte());
        this.resultStatus = ResultStatus.valueOf(buffer.readUnsignedByte());
        this.pitLaneTimerActive = PitLaneTimerActive.valueOf(buffer.readUnsignedByte());
        this.pitLaneTimeInLaneInMS = buffer.readFloatLE();
        this.pitStopTimerInMS = buffer.readFloatLE();
        this.pitStopShouldServePen = buffer.readFloatLE();
        return this;
    }

    public ByteBuf fillBuffer(ByteBuf buffer) {
        buffer.writeFloatLE(this.lastLapTime);
        buffer.writeFloatLE(this.currentLapTime);
        buffer.writeShortLE(this.sector1TimeInMS);
        buffer.writeShortLE(this.sector2TimeInMS);
        buffer.writeFloatLE(this.lapDistance);
        buffer.writeFloatLE(this.totalDistance);
        buffer.writeFloatLE(this.safetyCarDelta);
        buffer.writeByte(this.carPosition);
        buffer.writeByte(this.currentLapNum);
        buffer.writeByte(this.pitStatus.getValue());
        buffer.writeByte(this.sector.getValue());
        buffer.writeByte(this.currentLapInvalid);
        buffer.writeByte(this.penalties);
        buffer.writeByte(this.warnings);
        buffer.writeByte(this.numUnservedDriveThroughPens);
        buffer.writeByte(this.numUnservedStopGoPens);
        buffer.writeByte(this.gridPosition);
        buffer.writeByte(this.driverStatus.getValue());
        buffer.writeByte(this.resultStatus.getValue());
        buffer.writeByte(this.pitLaneTimerActive.getValue());
        buffer.writeFloatLE(this.pitLaneTimeInLaneInMS);
        buffer.writeFloatLE(this.pitStopTimerInMS);
        buffer.writeFloatLE(this.pitStopShouldServePen);
        return buffer;
    }


    @Override
    public String toString() {
        return "LapData{" +
                "lastLapTime=" + lastLapTime +
                ", currentLapTime=" + currentLapTime +
                ", sector1TimeInMS=" + sector1TimeInMS +
                ", sector2TimeInMS=" + sector2TimeInMS +
                ", lapDistance=" + lapDistance +
                ", totalDistance=" + totalDistance +
                ", safetyCarDelta=" + safetyCarDelta +
                ", carPosition=" + carPosition +
                ", currentLapNum=" + currentLapNum +
                ", pitStatus=" + pitStatus +
                ", sector=" + sector +
                ", currentLapInvalid=" + currentLapInvalid +
                ", penalties=" + penalties +
                ", warnings=" + warnings +
                ", numUnservedDriveThroughPens=" + numUnservedDriveThroughPens +
                ", numUnservedStopGoPens=" + numUnservedStopGoPens +
                ", gridPosition=" + gridPosition +
                ", driverStatus=" + driverStatus +
                ", resultStatus=" + resultStatus +
                ", pitLaneTimerActive=" + pitLaneTimerActive +
                ", pitLaneTimeInLaneInMS=" + pitLaneTimeInLaneInMS +
                ", pitStopTimerInMS=" + pitStopTimerInMS +
                ", pitStopShouldServePen=" + pitStopShouldServePen +
                '}';
    }
}
