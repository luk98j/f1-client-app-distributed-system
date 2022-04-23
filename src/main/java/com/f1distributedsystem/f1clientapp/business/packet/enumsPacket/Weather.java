package com.f1distributedsystem.f1clientapp.business.packet.enumsPacket;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum Weather {
    CLEAR(0),
    LIGHT_CLOUD(1),
    OVERCAST(2),
    LIGHT_RAIN(3),
    HEAVY_RAIN(4),
    STORM(5);

    private static Map<Integer, Weather> map = new HashMap<>();

    static {
        for (Weather weather : Weather.values()) {
            map.put(weather.value, weather);
        }
    }

    private int value;

    Weather(int value) {
        this.value = value;
    }

    public static Weather valueOf(int value) {
        return map.get(value);
    }

}
