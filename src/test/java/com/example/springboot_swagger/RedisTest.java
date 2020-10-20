package com.example.springboot_swagger;


import com.example.springboot_swagger.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.flushDb();
        redisTemplate.opsForValue().set("test_key","test_value");
    }

    @Test
    void test() throws JsonProcessingException {
        User user = new User();
        user.setName("zhangSan");
        user.setAge(18);
        String userStr = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user", userStr);
    }

    @Test
    void test2() {
        User user = new User();
        user.setName("zhangSan");
        user.setAge(18);
        redisTemplate.opsForValue().set("user2", user); //直接传对象，对象必须序列化
    }

    @Test
    void test3() {
        stringRedisTemplate.opsForValue().set("user2", "test2");
    }
}
