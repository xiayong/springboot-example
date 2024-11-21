package me.xiayong.example.util;

import java.util.UUID;

/**
 * @author: Yong Xia.
 * @date: Nov-22/2024
 * @since: v1.0
 **/
public final class UUIDGenerator {
    private UUIDGenerator() {}


    public static final String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
