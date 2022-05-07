package com.f1distributedsystem.f1clientapp.business.packet.data;

import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StartLights {
    private short numLights;

    public StartLights fill(ByteBuf buffer) {
        this.numLights = buffer.readUnsignedByte();
        return this;
    }

    @Override
    public String toString() {
        return "StartLights[numLights=" + this.numLights +
                "]";
    }
}
