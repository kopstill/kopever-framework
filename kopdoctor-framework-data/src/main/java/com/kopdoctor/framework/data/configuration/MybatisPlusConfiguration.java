package com.kopdoctor.framework.data.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(basePackages = "com.kopdoctor.**.dao")
@Configuration
public class MybatisPlusConfiguration {

}
