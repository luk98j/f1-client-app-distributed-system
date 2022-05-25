package com.f1distributedsystem.f1clientapp.dto.impl;

import com.f1distributedsystem.f1clientapp.dto.MainDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CarTelemetryList extends MainDto {
    private final BigInteger sessionUid;
    private final List<CarTelemetryDto> carTelemetryDtoList;
}
