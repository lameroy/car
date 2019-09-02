package com.car;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@EnableTransactionManagement
@MapperScan(basePackages = "com.car.mapper")
@SpringBootApplication
@EnableScheduling
public class CarServerApplication {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(CarServerApplication.class, args);
    }


    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Bean
    public ValueOperations<String, String> valueOperations() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        return valueOperations;
    }

}
