package com.f1distributedsystem.f1clientapp.dto.impl;

import com.f1distributedsystem.f1clientapp.utilities.Const;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CarTelemetryDto {
    private int carIndex;
    private short drs;
    private int brakesTemperature[];
    private short tyresSurfaceTemperature[];
}
