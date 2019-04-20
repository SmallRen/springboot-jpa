package com.jpa.dao;

import com.jpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author: renbaojia
 * @CreateDate: 2019-04-17 17:38:00
 * @Description: d
 * @Version: 3.4.0
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 通过名称找到用户。
     *
     * @param username 用户名
     * @return 单个用户
     */
    User findByUsername(String username);

    /**
     * 通过名称和年龄找到用户
     *
     *
     * @param username 用户名
     * @param password 密码
     * @return 单个用户。
     */
    User findByUsernameAndPassword(String username, String password);

    /**
     * 通过名称模糊查询并分页
     *
     * @param username 用户名
     * @return 用户集合。
     */
    Page<User> findByUsernameLike(String username, Pageable pageable);

    /**
     * 使用hql查询:name对应@Param里的name
     *
     * @param username 用户名
     * @return 用户
     */
    @Query("from User u where u.username=:username")
    User findByHQL(@Param("username") String username);

    /**
     * 使用sql查询?1表示第一个参数，?2表示第二个参数  #{#entityName}自动获取实体类的table name
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户
     */
    @Query(value = "select * from #{#entityName} where username = ?1 and password = ?2", nativeQuery = true)
    User findBySQL(@Param("username") String username,@Param("password")  String password);



}
