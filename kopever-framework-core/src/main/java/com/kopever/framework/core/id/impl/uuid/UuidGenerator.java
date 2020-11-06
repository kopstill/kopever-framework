package com.kopever.framework.core.id.impl.uuid;

import com.kopever.framework.common.util.UUIDUtil;
import com.kopever.framework.core.id.IdGenerator;

public class UuidGenerator implements IdGenerator {

    public String getString() {
        return UUIDUtil.getUUIDString();
    }

}
