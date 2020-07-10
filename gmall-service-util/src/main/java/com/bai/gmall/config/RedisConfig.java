package com.bai.gmall.config;

import com.bai.gmall.util.RedisUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    public String host;

    @Value("${spring.redis.port}")
    public int port;

    @Bean
    public RedisUtil getRedisUtil(){
        RedisUtil redisUtil = new RedisUtil();
        redisUtil.initPool(host,port);
        return redisUtil;
    }

}
