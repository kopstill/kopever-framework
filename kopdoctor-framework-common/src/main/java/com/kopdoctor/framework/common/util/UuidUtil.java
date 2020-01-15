package com.kopdoctor.framework.common.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UuidUtil {

    public static UUID getUUID() {
        return UUID.randomUUID();
    }

    public static String getUUIDString() {
        return getUUID().toString();
    }

}
