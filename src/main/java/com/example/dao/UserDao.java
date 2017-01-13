package com.example.dao;

/**
 * Created by Administrator on 2017/1/11.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.User;
import com.example.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public List<User> selectUser(String userName){
        return userMapper.selectUser(userName);
    }
    public int insertUser(String userName, String password){
        return userMapper.insertUser(userName, password);
    }

    public int insertUserWithBackId(User user){
        return userMapper.insertUserWithBackId(user);
    }

}