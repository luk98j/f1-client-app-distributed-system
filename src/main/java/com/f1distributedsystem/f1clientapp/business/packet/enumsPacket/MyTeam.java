package com.f1distributedsystem.f1clientapp.business.packet.enumsPacket;

import java.util.HashMap;
import java.util.Map;

public enum MyTeam {
    MY_TEAM(1),
    OTHERWISE(1);

    private static Map<Integer, MyTeam> map = new HashMap<>();

    static {
        for (MyTeam myTeam : MyTeam.values()) {
            map.put(myTeam.value, myTeam);
        }
    }

    private int value;

    MyTeam(int value) {
        this.value = value;
    }

    public static MyTeam valueOf(int value) {
        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
