package com.kopever.framework.core.id.impl.uuid;

import com.kopever.framework.common.util.UUIDUtil;
import com.kopever.framework.core.id.StringIdGenerator;

public class UuidGenerator implements StringIdGenerator {

    public String getString() {
        return UUIDUtil.getUUIDString();
    }

}