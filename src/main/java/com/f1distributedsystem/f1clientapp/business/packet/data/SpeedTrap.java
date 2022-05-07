package com.f1distributedsystem.f1clientapp.business.packet.data;

import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpeedTrap {
    private short vehicleIdx;
    private float speed;

    public SpeedTrap fill(ByteBuf buffer) {
        this.vehicleIdx = buffer.readUnsignedByte();
        this.speed = buffer.readFloatLE();
        return this;
    }

    @Override
    public String toString() {
        return "SpeedTrap[vehicleIdx=" + this.vehicleIdx +
                ",speed=" + this.speed +
                "]";
    }
}
