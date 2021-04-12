package com.rajdeep.redisdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class SpringBootRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisApplication.class, args);
	}
	
	@Bean
	LettuceConnectionFactory redisConnectionFactory() {
		LettuceClientConfiguration clientConfig=LettuceClientConfiguration.builder()
				.build();
		
		RedisStandaloneConfiguration serverConfig=new RedisStandaloneConfiguration("localhost",6379);
		return new LettuceConnectionFactory(serverConfig,clientConfig);
	}
	
	@Bean
	RedisTemplate redisTemplate(){
		RedisTemplate redisTemplate=new RedisTemplate();
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		return redisTemplate;
  }
	
	
	
	
	

}
