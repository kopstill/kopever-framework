package com.kopever.framework.core.id;

import com.kopever.framework.common.exception.SystemRuntimeException;

public interface StringIdGenerator extends IdGenerator {

    default Object getId() {
        return getString();
    }

    default String getString() {
        throw new SystemRuntimeException("No string id generator implement");
    }

}
