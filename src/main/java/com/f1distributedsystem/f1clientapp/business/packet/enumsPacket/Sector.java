package com.f1distributedsystem.f1clientapp.business.packet.enumsPacket;

import java.util.HashMap;
import java.util.Map;

public enum Sector {
    SECTOR1(0),
    SECTOR2(1),
    SECTOR3(2);

    private static Map<Integer, Sector> map = new HashMap<>();

    static {
        for (Sector sector : Sector.values()) {
            map.put(sector.value, sector);
        }
    }

    private int value;

    Sector(int value) {
        this.value = value;
    }

    public static Sector valueOf(int value) {
        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
