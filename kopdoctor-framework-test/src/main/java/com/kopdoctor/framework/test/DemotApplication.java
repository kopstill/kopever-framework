package com.kopdoctor.framework.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.kopdoctor")
public class DemotApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemotApplication.class);
    }

}
