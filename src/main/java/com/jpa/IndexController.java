package com.jpa;

import com.jpa.entity.User;
import com.jpa.service.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: renbaojia
 * @CreateDate: 2019-04-17 17:48:23
 * @Description: TODO
 * @Version: 3.4.0
 */
@RestController
@RequestMapping("/")
public class IndexController {
    private final UserServiceImpl userService;

    /**
     * 构造器进行注入
     *
     * @param userService
     */
    public IndexController(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**
     * 查找所有用户
     * @return 用户集合
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAll() {
        return userService.findAll();
    }
}
