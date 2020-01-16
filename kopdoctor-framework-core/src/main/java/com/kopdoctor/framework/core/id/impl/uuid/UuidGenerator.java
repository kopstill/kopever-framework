package com.kopdoctor.framework.core.id.impl.uuid;

import com.kopdoctor.framework.common.util.UUIDUtil;
import com.kopdoctor.framework.core.id.IdGenerator;

public class UuidGenerator implements IdGenerator {

    public String getString() {
        return UUIDUtil.getUUIDString();
    }

}
