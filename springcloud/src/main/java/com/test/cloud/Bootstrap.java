package com.test.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author shenfl
 */
@SpringBootApplication
@EnableFeignClients
public class Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class);
    }
}
