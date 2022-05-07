package com.f1distributedsystem.f1clientapp.business.packet.data;

import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StopGoPenaltyServed {
    private short vehicleIdx;

    public StopGoPenaltyServed fill(ByteBuf buffer) {
        this.vehicleIdx = buffer.readUnsignedByte();
        return this;
    }

    @Override
    public String toString() {
        return "StopGoPenaltyServed[vehicleIdx=" + this.vehicleIdx +
                "]";
    }
}
