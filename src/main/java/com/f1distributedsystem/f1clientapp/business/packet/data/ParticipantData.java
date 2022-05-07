package com.f1distributedsystem.f1clientapp.business.packet.data;

import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.Driver;
import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.MyTeam;
import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.Nationality;
import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.Team;
import com.f1distributedsystem.f1clientapp.utilities.Utils;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipantData {
    public static final int NAME_LENGTH = 48;

    private short aiControlled;
    private Driver driverId;
    private short networkId;
    private Team teamId;
    private MyTeam myTeam;
    private short raceNumber;
    private Nationality nationality;
    private String name;
    private short yourTelemetry;

    public ParticipantData fill(ByteBuf buffer) {
        this.aiControlled = buffer.readUnsignedByte();
        this.driverId = Driver.valueOf(buffer.readUnsignedByte());
        this.networkId = buffer.readUnsignedByte();
        this.teamId = Team.valueOf(buffer.readUnsignedByte());
        this.myTeam = MyTeam.valueOf(buffer.readUnsignedByte());
        this.raceNumber = buffer.readUnsignedByte();
        this.nationality = Nationality.valueOf(buffer.readUnsignedByte());
        this.name = Utils.readString(buffer, ParticipantData.NAME_LENGTH);
        this.yourTelemetry = buffer.readUnsignedByte();
        return this;
    }

    @Override
    public String toString() {
        return "ParticipantData[aiControlled=" + this.aiControlled +
                ",driverId=" + this.driverId +
                ",teamId=" + this.teamId +
                ",networkId=" + this.networkId +
                ",raceNumber=" + this.raceNumber +
                ",nationality=" + this.nationality +
                ",name=" + this.name +
                ",myTeam;=" + this.myTeam +
                ",yourTelemetry=" + this.yourTelemetry +
                "]";
    }
}
