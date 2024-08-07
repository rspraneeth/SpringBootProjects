package com.rsp.config;

import com.rsp.model.Country;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration {

    @Bean
    public JedisConnectionFactory jedisConnect(){
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        //config properties
        return connectionFactory;
    }

    @Bean
    public RedisTemplate<String, Country> redisTemplate(){
        RedisTemplate<String, Country> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnect());
        return redisTemplate;
    }
}
