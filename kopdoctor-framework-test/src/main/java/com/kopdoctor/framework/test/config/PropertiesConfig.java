package com.kopdoctor.framework.test.config;

import com.kopdoctor.framework.test.config.properties.DemoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConfig {

    @Bean
    public DemoProperties demoConfig() {
        return new DemoProperties();
    }

}
