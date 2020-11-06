package com.kopever.framework.web.configuration;

import com.kopever.framework.core.constant.ConfigKey;
import com.kopever.framework.web.constant.WebOrder;
import com.kopever.framework.web.filter.LoggingFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {

    @Value("${" + ConfigKey.FILTER_LOGGING_URL_PATTERNS + ":/*}")
    private String urlPatterns;

    @Bean
    @ConditionalOnProperty(value = ConfigKey.FILTER_LOGGING_ENABLED, havingValue = "true")
    public FilterRegistrationBean<LoggingFilter> filterRegistrationBean() {
        FilterRegistrationBean<LoggingFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LoggingFilter());
        filterRegistrationBean.addUrlPatterns(urlPatterns.split(","));
        filterRegistrationBean.setOrder(WebOrder.LOGGING_FILTER_ORDER);

        return filterRegistrationBean;
    }

}
