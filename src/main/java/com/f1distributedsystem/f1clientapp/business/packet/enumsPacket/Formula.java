/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package com.f1distributedsystem.f1clientapp.business.packet.enumsPacket;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Formula
 */
@Getter
public enum Formula {
    F1_MODERN(0),
    F1_CLASSIC(1),
    F2(2),
    F1_GENERIC(3);
    
    private static Map<Integer, Formula> map = new HashMap<>();

    static {
        for (Formula formula : Formula.values()) {
            map.put(formula.value, formula);
        }
    }

    private int value;
    
    Formula(int value) {
        this.value = value;
    }

    public static Formula valueOf(int value) {
        return map.get(value);
    }

}