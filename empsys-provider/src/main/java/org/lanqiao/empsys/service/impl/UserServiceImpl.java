package org.lanqiao.empsys.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.lanqiao.empsys.dao.UserMapper;
import org.lanqiao.empsys.domain.User;
import org.lanqiao.empsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService(interfaceClass = UserService.class ,version = "1.0",timeout = 50000)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUser(User user) {
        return userMapper.selectUser(user);
    }
}
