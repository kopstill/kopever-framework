package com.kopever.framework.core.id.config;

import com.kopever.framework.core.id.IdGenerator;
import com.kopever.framework.core.id.impl.snowflake.SnowflakeIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@ConditionalOnClass(IdGenerator.class)
public class IdConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public IdGenerator idGenerator() {
        logger.info("Init SnowflakeIdGenerator");
        return new SnowflakeIdGenerator();
    }

}
