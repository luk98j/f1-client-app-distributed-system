package com.f1distributedsystem.f1clientapp.business.packet.impl;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;
import com.f1distributedsystem.f1clientapp.business.packet.data.ParticipantData;
import com.f1distributedsystem.f1clientapp.utilities.Const;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PacketParticipantsData extends Packet {
    private short numActiveCars;
    private List<ParticipantData> participants = new ArrayList<>(Const.CARS);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Participants[");
        sb.append(super.toString());
        sb.append(",numActiveCars=" + this.numActiveCars);
        sb.append(",participants=");
        for (ParticipantData p : participants) {
            sb.append(p.toString() + ",");
        }
        sb.replace(sb.length() - 1, sb.length() - 1, "]");
        return sb.toString();
    }

    @Override
    public Packet fill(ByteBuf buffer) {
        super.fill(buffer);
        this.numActiveCars = buffer.readUnsignedByte();
        for (int i = 0; i < this.numActiveCars; i++) {
            ParticipantData pd = new ParticipantData();
            this.participants.add(pd.fill(buffer));
        }
        return this;
    }
}
