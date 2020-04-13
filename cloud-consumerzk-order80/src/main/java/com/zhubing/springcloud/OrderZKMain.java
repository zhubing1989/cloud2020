package com.zhubing.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain.class,args);
    }
}
