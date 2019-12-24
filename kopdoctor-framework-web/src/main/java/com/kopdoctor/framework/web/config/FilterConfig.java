package com.kopdoctor.framework.web.config;

import com.kopdoctor.framework.web.constant.WebOrder;
import com.kopdoctor.framework.web.filter.LoggingFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Value("${kopdoctor.framework.filter.logging.enabled:true}")
    private boolean loggingFilterEnabled;

    @Value("${kopdoctor.framework.filter.logging.url-patterns:/*}")
    private String urlPatterns;

    @Bean
    public FilterRegistrationBean<LoggingFilter> filterRegistrationBean() {
        FilterRegistrationBean<LoggingFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        LoggingFilter loggingFilter = new LoggingFilter();
        filterRegistrationBean.setFilter(loggingFilter);
        filterRegistrationBean.addUrlPatterns(urlPatterns.split(","));
        filterRegistrationBean.setOrder(WebOrder.LOGGING_FILTER_ORDER);
        filterRegistrationBean.setEnabled(loggingFilterEnabled);

        return filterRegistrationBean;
    }

}
