package com.f1distributedsystem.f1clientapp.dto.impl;

import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.ResultStatus;
import com.f1distributedsystem.f1clientapp.utilities.Const;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CarFinalClasificationDto {
    private int carIndex;
    private short position;
    private short numLaps;
    private short gridPosition;
    private short points;
    private short numPitStops;
    private ResultStatus resultStatus;
    private float bestLapTime;
    private double totalRaceTime;
    private short penaltiesTime;
    private short numPenalties;
    private short numTyreStints;
}
