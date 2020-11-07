package com.kopever.framework.data.configuration;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.kopever.**.mapper")
@Configuration
public class MybatisConfiguration {

}
