package com.f1distributedsystem.f1clientapp.business.packet.enumsPacket;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum SessionType {
    UNKNOWN(0),
    P1(1),
    P2(2),
    P3(3),
    SHORT_P(4),
    Q1(5),
    Q2(6),
    Q3(7),
    SHORT_Q(8),
    OSQ(9),
    R(10),
    R2(11),
    TIME_TRIAL(12);

    private static Map<Integer, SessionType> map = new HashMap<>();

    static {
        for (SessionType sessionType : SessionType.values()) {
            map.put(sessionType.value, sessionType);
        }
    }

    private int value;

    SessionType(int value) {
        this.value = value;
    }

    public static SessionType valueOf(int value) {
        return map.get(value);
    }
}
