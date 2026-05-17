package com.example.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class BlockService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public boolean isBlocked(String phoneNumber) {

        Boolean blocked = redisTemplate
                .opsForSet()
                .isMember("blocked-users", phoneNumber);

        return blocked != null && blocked;
    }
}