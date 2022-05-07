package com.f1distributedsystem.f1clientapp.business.packet.data;

import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.InfringementType;
import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.PenaltyType;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Penalty {
    private PenaltyType penaltyType;
    private InfringementType infringementType;
    private short vehicleIdx;
    private short otherVehicleIdx;
    private short time;
    private short lapNum;
    private short placesGained;

    public Penalty fill(ByteBuf buffer) {
        this.penaltyType = PenaltyType.valueOf(buffer.readUnsignedByte());
        this.infringementType = InfringementType.valueOf(buffer.readUnsignedByte());
        this.vehicleIdx = buffer.readUnsignedByte();
        this.otherVehicleIdx = buffer.readUnsignedByte();
        this.time = buffer.readUnsignedByte();
        this.lapNum = buffer.readUnsignedByte();
        this.placesGained = buffer.readUnsignedByte();
        return this;
    }

    @Override
    public String toString() {
        return "Penalty[penaltyType=" + this.penaltyType +
                ",infringementType=" + this.infringementType +
                ",vehicleIdx=" + this.vehicleIdx +
                ",otherVehicleIdx=" + this.otherVehicleIdx +
                ",time=" + this.time +
                ",lapNum=" + this.lapNum +
                ",placesGained=" + this.placesGained +
                "]";
    }
}
