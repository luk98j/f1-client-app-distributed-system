package com.f1distributedsystem.f1clientapp.business.packet.impl;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;
import com.f1distributedsystem.f1clientapp.business.packet.data.CarTelemetryData;
import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.MfdPanel;
import com.f1distributedsystem.f1clientapp.utilities.Const;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PacketCarTelemetryData extends Packet {
    private List<CarTelemetryData> carTelemetryData = new ArrayList<>(Const.CARS);
    private MfdPanel mfdPanelIndex;
    private MfdPanel mfdPanelIndexSecondaryPlayer;
    private short suggestedGear;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CarTelemetry[");
        sb.append(super.toString());
        sb.append(",carTelemetryData=");
        for (CarTelemetryData c : carTelemetryData) {
            sb.append(c.toString() + ",");
        }
        sb.append(",mfdPanelIndex=" + this.mfdPanelIndex);
        sb.append(",mfdPanelIndexSecondaryPlayer=" + this.mfdPanelIndexSecondaryPlayer);
        sb.append(",suggestedGear=" + this.suggestedGear);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Packet fill(ByteBuf buffer) {
        super.fill(buffer);
        for (int i = 0; i < Const.CARS; i++) {
            CarTelemetryData ctd = new CarTelemetryData();
            this.carTelemetryData.add(ctd.fill(buffer));
        }
        this.mfdPanelIndex = MfdPanel.valueOf(buffer.readUnsignedByte());
        this.mfdPanelIndexSecondaryPlayer = MfdPanel.valueOf(buffer.readUnsignedByte());
        this.suggestedGear = buffer.readByte();
        return this;
    }
}
