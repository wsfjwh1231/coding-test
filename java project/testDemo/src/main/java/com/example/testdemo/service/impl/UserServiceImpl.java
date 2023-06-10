package com.example.testdemo.service.impl;

import com.example.testdemo.entity.User;
import com.example.testdemo.mapper.UserMapper;
import com.example.testdemo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Override
    public void login() {
        System.out.println("用户登录开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("用户登录结束");
    }

    @Override
    public void register() {
        System.out.println("用户注册开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("用户注册结束");
    }
}
