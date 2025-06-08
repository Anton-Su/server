package com.kursovaya.server;

import java.util.UUID;

public class Generator {
    public static String generateNewCode() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
