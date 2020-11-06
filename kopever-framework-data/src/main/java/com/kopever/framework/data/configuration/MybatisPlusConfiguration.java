package com.kopever.framework.data.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(basePackages = "com.kopever.**.dao")
@Configuration
public class MybatisPlusConfiguration {

}
