package com.f1distributedsystem.f1clientapp.dto.impl;

import com.f1distributedsystem.f1clientapp.dto.MainDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class ParticipantListDto extends MainDto {
    private final BigInteger sessionUid;
    private final List<ParticipantDto> participantDtoList;
}
