package com.fishmoun.covision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisTestController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/set")
    public String set() {
        redisTemplate.opsForValue().set("name", "Harper");
        return "ok";
    }

    @GetMapping("/get")
    public Object get() {
        return redisTemplate.opsForValue().get("name");
    }
}
