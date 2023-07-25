package cn.vincent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/r")
public class RedisController {

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/getValue/{keyName}")
    public String get(@PathVariable String keyName) {
        String userName = (String) redisTemplate.opsForValue().get(keyName);
        return userName;
    }

    @GetMapping("/setUserName/{userName}")
    public String set(@PathVariable String userName) {
        redisTemplate.opsForValue().set("username_1", userName);
        return userName;
    }

}
