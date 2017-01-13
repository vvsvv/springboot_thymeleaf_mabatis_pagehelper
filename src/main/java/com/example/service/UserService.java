package com.example.service;

/**
 * Created by Administrator on 2017/1/11.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.domain.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User>  selectUser(String username){
        return userDao.selectUser(username);
    }

    public boolean addUser(String username, String password){
        return userDao.insertUser(username, password)==1?true:false;
    }

    public User addUserWithBackId(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userDao.insertUserWithBackId(user);//该方法后，主键已经设置到user中了
        return user;
    }

}