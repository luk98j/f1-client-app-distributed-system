package com.f1distributedsystem.f1clientapp.business.packet.data;

import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamMateInPits {
    private short vehicleIdx;


    public TeamMateInPits fill(ByteBuf buffer) {
        this.vehicleIdx = buffer.readUnsignedByte();
        return this;
    }

    @Override
    public String toString() {
        return "TeamMateInPits[vehicleIdx=" + this.vehicleIdx +
                "]";
    }
}
