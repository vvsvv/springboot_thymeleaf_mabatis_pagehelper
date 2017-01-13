package com.example.mapper;

/**
 * Created by Administrator on 2017/1/11.
 */
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.example.domain.User;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Insert("INSERT INTO test_b_user(username, password) VALUES(#{username},#{password})")
    public int insertUser(@Param("username") String username, @Param("password")  String password);

    @Update("INSERT INTO test_b_user(username, password) VALUES(#{username},#{password})")
    public int UpdateUser(@Param("uid") Integer uid,@Param("username") String username, @Param("password")  String password);
    /**
     * 插入用户，并将主键设置到user中
     * 注意：返回的是数据库影响条数，即1
     */
    public int insertUserWithBackId(User user);

    public List<User> selectUser(String userName);
}