package com.f1distributedsystem.f1clientapp.dto.impl;

import com.f1distributedsystem.f1clientapp.dto.MainDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
public class PenaltyDto extends MainDto {
    private final BigInteger sessionUid;
    private final int carId;
    private final String penaltyType;
    private final String time;
}
