package com.f1distributedsystem.f1clientapp.business.packet.data;

import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RaceWinner {
    private short vehicleIdx;

    public RaceWinner fill(ByteBuf buffer) {
        this.vehicleIdx = buffer.readUnsignedByte();
        return this;
    }

    @Override
    public String toString() {
        return "RaceWinner[vehicleIdx=" + this.vehicleIdx +
                "]";
    }
}
