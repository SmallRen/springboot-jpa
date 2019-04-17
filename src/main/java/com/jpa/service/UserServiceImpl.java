package com.jpa.service;

import com.jpa.dao.UserRepository;
import com.jpa.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: renbaojia
 * @CreateDate: 2019-04-17 17:49:58
 * @Description: TODO
 * @Version: 3.4.0
 */
@Service
public class UserServiceImpl {
    private final UserRepository userRepository;

    /**
     * 构造器注入
     * @param userRepository
     */
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
       return  userRepository.findAll();
    }
}
