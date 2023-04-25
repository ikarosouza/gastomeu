package br.com.reiosse.gastomeu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Periodicity {
    DAILY("Daily"),
    WEEKLY("Weekly"),
    BIWEEKLY("Biweekly"),
    MONTHLY("Monthly"),
    QUARTERLY("Quarterly"),
    SEMIANNUAL("Semiannual"),
    ANNUAL("Annual");

    private final String label;

    public static Periodicity fromString(String value) {
        for (Periodicity periodicity : Periodicity.values()) {
            if (periodicity.getLabel().equalsIgnoreCase(value)) {
                return periodicity;
            }
        }
        throw new IllegalArgumentException("No constant with label " + value + " found for Periodicity enum");
    }
}
