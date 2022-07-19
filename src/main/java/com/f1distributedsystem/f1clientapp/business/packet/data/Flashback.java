package com.f1distributedsystem.f1clientapp.business.packet.data;

import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Flashback {
    private long flashbackFrameIdentifier;
    private float flashbackSessionTime;

    public Flashback fill(ByteBuf buffer) {
        this.flashbackFrameIdentifier = buffer.readUnsignedIntLE();
        this.flashbackSessionTime = buffer.readFloatLE();
        return this;
    }

    @Override
    public String toString() {
        return "Flashback[flashbackFrameIdentifier=" + this.flashbackFrameIdentifier +
                ",flashbackSessionTime=" + this.flashbackSessionTime +
                "]";
    }
}
