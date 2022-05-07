package com.f1distributedsystem.f1clientapp.business.packet.data;

import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FastestLap {
    private short vehicleIdx;
    private float lapTime;

    public FastestLap fill(ByteBuf buffer) {
        this.vehicleIdx = buffer.readUnsignedByte();
        this.lapTime = buffer.readFloatLE();
        return this;
    }

    @Override
    public String toString() {
        return "FastestLap[vehicleIdx=" + this.vehicleIdx +
                ",lapTime=" + this.lapTime +
                "]";
    }
}
