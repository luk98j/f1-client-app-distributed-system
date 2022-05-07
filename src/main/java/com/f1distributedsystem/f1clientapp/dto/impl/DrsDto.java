package com.f1distributedsystem.f1clientapp.dto.impl;

import com.f1distributedsystem.f1clientapp.dto.MainDto;
import lombok.AllArgsConstructor;

import java.math.BigInteger;

@AllArgsConstructor
public class DrsDto extends MainDto {
    private final BigInteger sessionUid;
    private final boolean enable;
}
