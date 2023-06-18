package com.example.testdemo.mybatisPlusTest.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.testdemo.mybatisPlusTest.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
public interface IUserService extends IService<User> {

    List<User> login();

    int register(User user);

    IPage<User> selectUserPage(IPage<User> page);

    User selectUserByUsername(String username);

    User selectUserAndGoodscardList(String username);



}
