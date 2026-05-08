package com.platzi.pizza.domain.enums;

/**
 * Enumeration for order delivery methods.
 *
 * This replaces magic strings like "D" and "C" with type-safe constants.
 * Benefits:
 * - IDE autocomplete
 * - Compile-time checking
 * - Self-documenting code
 * - Easy to iterate
 */
public enum OrderMethod {
    DELIVERY("D", "Delivery to customer address"),
    CARRYOUT("C", "Customer picks up order"),
    DINE_IN("I", "Dining in at restaurant"),
    CATERING("K", "Catering service");

    private final String code;
    private final String description;

    OrderMethod(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Find OrderMethod by code.
     *
     * @param code the delivery method code
     * @return the corresponding OrderMethod
     * @throws IllegalArgumentException if code is not recognized
     */
    public static OrderMethod fromCode(String code) {
        for (OrderMethod method : values()) {
            if (method.code.equalsIgnoreCase(code)) {
                return method;
            }
        }
        throw new IllegalArgumentException("Unknown order method code: " + code);
    }
}

