package com.chenjiajin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author com.chenjiajin
 */
@SpringBootApplication
@EnableDiscoveryClient  // Nacos注册中心
@MapperScan("com.chenjiajin.mapper")
@EnableFeignClients
public class SonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SonApplication.class, args);
    }


}
