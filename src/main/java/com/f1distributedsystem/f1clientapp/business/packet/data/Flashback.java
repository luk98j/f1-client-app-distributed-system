package com.f1distributedsystem.f1clientapp.business.packet.data;

import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Flashback {
    private float flashbackFrameIdentifier;
    private float flashbackSessionTime;

    public Flashback fill(ByteBuf buffer) {
        this.flashbackFrameIdentifier = buffer.readFloatLE();
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
