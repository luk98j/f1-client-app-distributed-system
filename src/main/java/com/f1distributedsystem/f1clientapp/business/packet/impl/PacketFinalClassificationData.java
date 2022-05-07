package com.f1distributedsystem.f1clientapp.business.packet.impl;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;
import com.f1distributedsystem.f1clientapp.business.packet.PacketHeader;
import com.f1distributedsystem.f1clientapp.business.packet.data.FinalClassificationData;
import com.f1distributedsystem.f1clientapp.utilities.Const;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class PacketFinalClassificationData extends Packet {
    // 839
    public static final int SIZE = PacketHeader.SIZE +
            1 +
            FinalClassificationData.SIZE * Const.CARS;

    private short numCars;
    private List<FinalClassificationData> finalClassificationData = new ArrayList<>(Const.CARS);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("FinalClassification[");
        sb.append(super.toString());
        sb.append("numCars=" + this.numCars);
        sb.append(",finalClassificationData=");
        for (FinalClassificationData f : finalClassificationData) {
            sb.append(f.toString() + ",");
        }
        sb.replace(sb.length() - 1, sb.length() - 1, "]");
        return  sb.toString();
    }

    @Override
    public Packet fill(ByteBuf buffer) {
        super.fill(buffer);
        this.numCars = buffer.readUnsignedByte();
        for (int i = 0; i < this.numCars; i++) {
            FinalClassificationData fcd = new FinalClassificationData();
            this.finalClassificationData.add(fcd.fill(buffer));
        }
        return this;
    }
}
