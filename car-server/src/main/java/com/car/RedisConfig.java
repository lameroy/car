package com.car;

import com.car.serializer.MyJackson2JsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

	@Bean(name = "jedisKeySerializer")
	public StringRedisSerializer jedisKeySerializer(){
		return new StringRedisSerializer();
	}

	@Bean(name = "jedisValueSerializer")
	public MyJackson2JsonRedisSerializer jedisValueSerializer(){
		return  new MyJackson2JsonRedisSerializer();
	}

	@Bean(name = "hashKeySerializer")
	public StringRedisSerializer hashKeySerializer(){
		return  new StringRedisSerializer();
	}

	@Bean(name = "hashValueSerializer")
	public JdkSerializationRedisSerializer hashValueSerializer(){
		return  new JdkSerializationRedisSerializer();
	}

	/**
	 * 重写Redis序列化方式，使用Json方式:
	 * 当我们的数据存储到Redis的时候，我们的键（key）和值（value）都是通过Spring提供的Serializer序列化到数据库的。RedisTemplate默认使用的是JdkSerializationRedisSerializer，StringRedisTemplate默认使用的是StringRedisSerializer。
	 * Spring Data JPA为我们提供了下面的Serializer：
	 * GenericToStringSerializer、Jackson2JsonRedisSerializer、JacksonJsonRedisSerializer、JdkSerializationRedisSerializer、OxmSerializer、StringRedisSerializer。
	 * 在此我们将自己配置RedisTemplate并定义Serializer。
	 * @param redisConnectionFactory
	 * @return
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		redisTemplate.setKeySerializer(jedisKeySerializer());
		redisTemplate.setValueSerializer(jedisValueSerializer());
		redisTemplate.setHashKeySerializer(hashKeySerializer());
		redisTemplate.setHashValueSerializer(hashValueSerializer());

		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

}
