package com.f1distributedsystem.f1clientapp.business.packet.impl;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;
import com.f1distributedsystem.f1clientapp.business.packet.data.CarStatusData;
import com.f1distributedsystem.f1clientapp.utilities.Const;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PacketCarStatusData extends Packet {
    private List<CarStatusData> carStatusData = new ArrayList<>(Const.CARS);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CarStatus[");
        sb.append(super.toString());
        sb.append(",carStatusData=");
        for (CarStatusData c : carStatusData) {
            sb.append(c.toString() + ",");
        }
        sb.replace(sb.length() - 1, sb.length() - 1, "]");
        return sb.toString();
    }

    @Override
    public Packet fill(ByteBuf buffer) {
        super.fill(buffer);
        for (int i = 0; i < Const.CARS; i++) {
            CarStatusData csd = new CarStatusData();
            this.carStatusData.add(csd.fill(buffer));
        }
        return this;
    }
}
