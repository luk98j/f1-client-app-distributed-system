package com.f1distributedsystem.f1clientapp.business.packet.data;

import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriveThroughPenaltyServed {
    private short vehicleIdx;

    public DriveThroughPenaltyServed fill(ByteBuf buffer) {
        this.vehicleIdx = buffer.readUnsignedByte();
        return this;
    }

    @Override
    public String toString() {
        return "DriveThroughPenaltyServed[vehicleIdx=" + this.vehicleIdx +
                "]";
    }
}
