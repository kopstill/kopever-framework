package com.kopdoctor.framework.core.id;

import com.kopdoctor.framework.common.exception.SystemRuntimeException;

public interface IdGenerator {

    default long getLong() {
        throw new SystemRuntimeException("No digital id generator implement");
    }

    default String getString() {
        throw new SystemRuntimeException("No string id generator implement");
    }

}