package com.f1distributedsystem.f1clientapp.business.packet.impl;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;
import com.f1distributedsystem.f1clientapp.business.packet.PacketHeader;
import com.f1distributedsystem.f1clientapp.business.packet.data.LapData;
import com.f1distributedsystem.f1clientapp.utilities.Const;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PacketLapData extends Packet {

    public static final int SIZE = PacketHeader.SIZE +
            LapData.SIZE * Const.CARS;

    private List<LapData> lapData = new ArrayList<>(Const.CARS);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("LapData[");
        sb.append(super.toString());
        sb.append(",lapData=");
        for (LapData l : lapData) {
            sb.append(l.toString() + ",");
        }
        sb.replace(sb.length() - 1, sb.length() - 1, "]");
        return sb.toString();
    }

    @Override
    public Packet fill(ByteBuf buffer) {
        super.fill(buffer);
        for (int i = 0; i < Const.CARS; i++) {
            LapData ld = new LapData();
            this.lapData.add(ld.fill(buffer));
        }
        return this;
    }

    @Override
    public ByteBuf fillBuffer(ByteBuf buffer) {
        super.fillBuffer(buffer);
        for (LapData ld : this.lapData) {
            ld.fillBuffer(buffer);
        }
        return buffer;
    }
}
