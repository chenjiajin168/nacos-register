package com.chenjiajin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author com.chenjiajin
 */
@SpringBootApplication
@EnableDiscoveryClient  // Nacos注册中心
@MapperScan("com.chenjiajin.mapper")
@EnableFeignClients
public class DaughterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaughterApplication.class, args);
    }


    @Bean
    @LoadBalanced  // Ribbon负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
