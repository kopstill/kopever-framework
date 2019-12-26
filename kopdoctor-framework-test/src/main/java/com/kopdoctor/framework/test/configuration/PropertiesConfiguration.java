package com.kopdoctor.framework.test.configuration;

import com.kopdoctor.framework.test.configuration.properties.DemoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConfiguration {

    @Bean
    public DemoProperties demoConfig() {
        return new DemoProperties();
    }

}
