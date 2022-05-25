package com.f1distributedsystem.f1clientapp.dto.impl;

import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.Driver;
import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.MyTeam;
import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.Nationality;
import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ParticipantDto {
    private Driver driverId;
    private short networkId;
    private String name;
    private short yourTelemetry;
}
