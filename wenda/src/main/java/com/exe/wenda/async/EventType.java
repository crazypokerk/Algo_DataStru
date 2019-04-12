package com.exe.wenda.async;

/**
 * @Date 2019/4/12 10:25
 */
public enum EventType {
    LIKE(0),
    COMMIT(1),
    LOGIN(2),
    MAIL(3);

    private int value;

    EventType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
