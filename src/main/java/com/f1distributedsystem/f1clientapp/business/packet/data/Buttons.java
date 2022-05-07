package com.f1distributedsystem.f1clientapp.business.packet.data;

import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Buttons {
    private float buttonStatus;

    public Buttons fill(ByteBuf buffer) {
        this.buttonStatus = buffer.readFloatLE();
        return this;
    }

    @Override
    public String toString() {
        return "Buttons[flashbackFrameIdentifier=" + this.buttonStatus +
                "]";
    }
}
