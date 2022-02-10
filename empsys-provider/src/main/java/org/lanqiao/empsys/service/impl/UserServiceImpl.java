package org.lanqiao.empsys.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.lanqiao.empsys.dao.UserMapper;
import org.lanqiao.empsys.domain.User;
import org.lanqiao.empsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@DubboService(interfaceClass = UserService.class ,version = "1.0",timeout = 50000)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(value = "LoginUser" ,key = "#user",condition = "#user.username.length()>0 && #user.password.length()>0")
    public User queryUser(User user) {

        return userMapper.selectUser(user);
    }
}
