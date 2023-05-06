package com.example.project504.service;

import com.example.project504.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2023-05-04 15:20:32
 */

public interface UserService {

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */
    User queryByUser(User user);

    /**
     * 修改用户
     *
     * @return 结果
     */
    int editUser(User user);

    /**
     * 注册
     *
     * @param user 实例对象
     * @return 实例对象
     */
    int addUser(User user);

    /**
     * 查询所有用户
     *
     * @return 实例对象
     */
    List<User> findAll();


    /**
     * 查询所有用户
     *
     * @return 实例对象
     */
    User findByUsername(String username);


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int deleteById(String id);

}
