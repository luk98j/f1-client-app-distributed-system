package com.f1distributedsystem.f1clientapp.business.packet.enumsPacket;

import java.util.HashMap;
import java.util.Map;

public enum ErsDeployMode {
    NONE(0),
    MEDIUM(1),
    OVERTAKE(2),
    HOTLAP(3);

    private static Map<Integer, ErsDeployMode> map = new HashMap<>();

    static {
        for (ErsDeployMode ersDeployMode : ErsDeployMode.values()) {
            map.put(ersDeployMode.value, ersDeployMode);
        }
    }

    private int value;

    ErsDeployMode(int value) {
        this.value = value;
    }

    public static ErsDeployMode valueOf(int value) {
        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
