package com.example.custom_queries2.entities;

import java.util.Random;

public enum StatusEnum {
    ONTIME,
    DELAYED,
    CANCELLED;

    private static final Random PRNG = new Random();

    public static StatusEnum randomStatusEnum()  {
        StatusEnum[] statusEnums = values();
        return statusEnums[PRNG.nextInt(statusEnums.length)];
    }
}