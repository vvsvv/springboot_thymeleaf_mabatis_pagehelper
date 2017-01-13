package com.example.web;

import com.example.domain.User;
import com.example.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brave on 16/10/9.
 *
 * 注意:
 *      这里要使用@Controller注解
 *      而不要使用@RestController
 *      否则return "hello";不能跳转到hello.html
 */
@Controller
public class HelloController {

    @Autowired
    private UserService userSerivce;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("hello", "hello Thymeleaf!");
        return "hello";
    }
    @RequestMapping("/layout")
    public String layout(ModelMap map) {
        map.addAttribute("layout", "layout!");
        return "layout";
    }

    @RequestMapping("/toAddUser")
    public String toAddUser(ModelMap map) {
        map.addAttribute("username", "test");
        map.addAttribute("password", "test");
        return "addUser";
    }

    @RequestMapping("/selectUser/{page}/{pageSize}")
    public String selectUser(ModelMap map,@PathVariable Integer page, @PathVariable Integer pageSize) {
        page = page == null ? 1 : page;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(page, pageSize);
        List<User> userList = userSerivce.selectUser("");
        PageInfo<User> pageInfo=new PageInfo(userList);
        System.out.println(">>>>>:"+pageInfo);
        map.addAttribute("pageInfo",pageInfo );
        return "selectUser";
    }



}


