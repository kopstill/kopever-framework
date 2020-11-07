package com.kopever.framework.core.id;

import com.kopever.framework.common.exception.SystemRuntimeException;

public interface NumberIdGenerator extends IdGenerator {

    default Object getId() {
        return getLong();
    }

    default long getLong() {
        throw new SystemRuntimeException("No digital id generator implement");
    }

}
