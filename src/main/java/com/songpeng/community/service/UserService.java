package com.songpeng.community.service;

import com.songpeng.community.dao.UserMapper;
import com.songpeng.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author songpeng
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id){
        return this.userMapper.selectById(id);
    }
}
