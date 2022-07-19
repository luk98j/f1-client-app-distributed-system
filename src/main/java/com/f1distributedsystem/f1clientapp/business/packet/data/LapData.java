package com.f1distributedsystem.f1clientapp.business.packet.data;

import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.*;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LapData {
    public static final int SIZE = 49;

    private long lastLapTime;
    private long currentLapTime;
    private int sector1TimeInMS;
    private int sector2TimeInMS;
    private float lapDistance;
    private float totalDistance;
    private float safetyCarDelta;
    private short carPosition;
    private short currentLapNum;
    private PitStatus pitStatus;
    private short numPitStops;
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
    private int pitLaneTimeInLaneInMS;
    private int pitStopTimerInMS;
    private short pitStopShouldServePen;

    public LapData fill(ByteBuf buffer) {
        this.lastLapTime = buffer.readUnsignedIntLE();
        this.currentLapTime = buffer.readUnsignedIntLE();
        this.sector1TimeInMS = buffer.readUnsignedShortLE();
        this.sector2TimeInMS = buffer.readUnsignedShortLE();
        this.lapDistance = buffer.readFloatLE();
        this.totalDistance = buffer.readFloatLE();
        this.safetyCarDelta = buffer.readFloatLE();
        this.carPosition = buffer.readUnsignedByte();
        this.currentLapNum = buffer.readUnsignedByte();
        this.pitStatus = PitStatus.valueOf(buffer.readUnsignedByte());
        this.numPitStops = buffer.readUnsignedByte();
        this.sector = Sector.valueOf(buffer.readUnsignedByte());
        this.currentLapInvalid = buffer.readUnsignedByte();
        this.penalties = buffer.readUnsignedByte();
        this.warnings = buffer.readUnsignedByte();
        this.numUnservedDriveThroughPens = buffer.readUnsignedByte();
        this.numUnservedStopGoPens = buffer.readUnsignedByte();
        this.gridPosition = buffer.readUnsignedByte();
        this.driverStatus = DriverStatus.valueOf(buffer.readUnsignedByte());
        this.resultStatus = ResultStatus.valueOf(buffer.readUnsignedByte());
        this.pitLaneTimerActive = PitLaneTimerActive.valueOf(buffer.readUnsignedByte());
        this.pitLaneTimeInLaneInMS = buffer.readUnsignedShortLE();
        this.pitStopTimerInMS = buffer.readUnsignedShortLE();
        this.pitStopShouldServePen = buffer.readUnsignedByte();
        return this;
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
