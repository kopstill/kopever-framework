package com.kopever.framework.common.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Dozer {

    public static <T> T map(Object source, Class<T> clazz) {
        if (source == null) return null;

        return DozerEnumInstance.INSTANCE.getInstance().map(source, clazz);
    }

    public static <T> void copy(Object source, T target) {
        if (source == null) return;

        DozerEnumInstance.INSTANCE.getInstance().map(source, target);
    }

}

enum DozerEnumInstance {

    INSTANCE;

    private Mapper mapper;

    DozerEnumInstance() {
        mapper = DozerBeanMapperBuilder.create().build();
    }

    public Mapper getInstance() {
        return mapper;
    }

}
