package com.example.proxyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
public class ProxyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyServiceApplication.class, args);
    }

}
