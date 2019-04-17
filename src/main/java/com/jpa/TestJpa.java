package com.jpa;

import com.jpa.dao.UserRepository;
import com.jpa.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: renbaojia
 * @CreateDate: 2019-04-17 17:38:50
 * @Description: TODO
 * @Version: 3.4.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestJpa {
    // 注入userRepository
    @Autowired
    private UserRepository userRepository;
    @Test
    public  void find(){
        List<User> all = userRepository.findAll();
        all.stream().forEach(a->System.out.println(a.getUsername()));
    }
}
