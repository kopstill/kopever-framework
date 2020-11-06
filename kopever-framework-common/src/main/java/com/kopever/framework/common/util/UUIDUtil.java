package com.kopever.framework.common.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UUIDUtil {

    public static UUID getUUID() {
        return UUID.randomUUID();
    }

    public static String getUUIDString() {
        return getUUID().toString();
    }

}
