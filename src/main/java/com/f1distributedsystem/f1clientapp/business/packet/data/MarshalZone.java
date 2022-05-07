package com.f1distributedsystem.f1clientapp.business.packet.data;

import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.ZoneFlag;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarshalZone {

    public static final int SIZE = 5;

    private float zoneStart;
    public ZoneFlag zoneFlag;


    public MarshalZone fill(ByteBuf buffer) {
        this.zoneStart = buffer.readFloatLE();
        this.zoneFlag = ZoneFlag.valueOf(buffer.readByte());
        return this;
    }

    public ByteBuf fillBuffer(ByteBuf buffer) {
        buffer.writeFloatLE(this.zoneStart);
        buffer.writeByte(this.zoneFlag.getValue());
        return buffer;
    }

    @Override
    public String toString() {
        return "MarshalZone[zoneStart=" + this.zoneStart +
                ",zoneFlag=" + this.zoneFlag +
                "]";
    }
}
