package com.f1distributedsystem.f1clientapp.business.packet.data;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;
import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.ResultStatus;
import com.f1distributedsystem.f1clientapp.utilities.Const;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class FinalClassificationData extends Packet {
    public static final int SIZE = 37;

    private short position;
    private short numLaps;
    private short gridPosition;
    private short points;
    private short numPitStops;
    private ResultStatus resultStatus;
    private long bestLapTime;
    private double totalRaceTime;
    private short penaltiesTime;
    private short numPenalties;
    private short numTyreStints;
    private short tyreStintsActual[] = new short[Const.TYRE_STINTS];
    private short tyreStintsVisual[] = new short[Const.TYRE_STINTS];


    public FinalClassificationData fill(ByteBuf buffer) {
        this.position = buffer.readUnsignedByte();
        this.numLaps = buffer.readUnsignedByte();
        this.gridPosition = buffer.readUnsignedByte();
        this.points = buffer.readUnsignedByte();
        this.numPitStops = buffer.readUnsignedByte();
        this.resultStatus = ResultStatus.valueOf(buffer.readUnsignedByte());
        this.bestLapTime = buffer.readUnsignedIntLE();
        this.totalRaceTime = buffer.readDoubleLE();
        this.penaltiesTime = buffer.readUnsignedByte();
        this.numPenalties = buffer.readUnsignedByte();
        this.numTyreStints = buffer.readUnsignedByte();
        for (int j = 0; j < Const.TYRE_STINTS; j++) {
            this.tyreStintsActual[j] = buffer.readUnsignedByte();
        }
        for (int j = 0; j < Const.TYRE_STINTS; j++) {
            this.tyreStintsVisual[j] = buffer.readUnsignedByte();
        }
        return this;
    }
    @Override
    public String toString() {
        return "FinalClassificationData[" +
                ",position=" + this.position +
                ",numLaps=" + this.numLaps +
                ",gridPosition=" + this.gridPosition +
                ",points=" + this.points +
                ",numPitStops=" + this.numPitStops +
                ",resultStatus=" + this.resultStatus +
                ",bestLapTime=" + this.bestLapTime +
                ",totalRaceTime=" + this.totalRaceTime +
                ",penaltiesTime=" + this.penaltiesTime +
                ",numPenalties=" + this.numPenalties +
                ",numTyreStints=" + this.numTyreStints +
                ",tyreStintsActual=" + Arrays.toString(tyreStintsActual) +
                ",tyreStintsVisual=" + Arrays.toString(this.tyreStintsVisual) +
                "]";
    }
}
