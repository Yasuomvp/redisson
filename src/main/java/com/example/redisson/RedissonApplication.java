package com.example.redisson;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RedissonApplication {


    public static void main(String[] args) {
        SpringApplication.run(RedissonApplication.class, args);
    }

}
