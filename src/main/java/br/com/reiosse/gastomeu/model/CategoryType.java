package br.com.reiosse.gastomeu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryType {
    EXPENSE("Expense"),
    INCOME("Income");

    private final String label;

    public static CategoryType fromString(String value) {
        for (CategoryType type : CategoryType.values()) {
            if (type.getLabel().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No constant with label " + value + " found for CategoryType enum");
    }
}

