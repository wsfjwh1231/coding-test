package com.example.testdemo.mybatisPlusTest.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.testdemo.mybatisPlusTest.entity.User;
import com.example.testdemo.mybatisPlusTest.mapper.UserMapper;
import com.example.testdemo.mybatisPlusTest.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> login() {
        System.out.println("用户登录开始");
//        userMapper.selectUserList();
        List<User> userList = userMapper.selectList(null);
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("用户登录结束");

        return userList;
    }

    @Override
    public int register() {

        return 1;
    }

    @Override
    public IPage<User> selectUserPage(IPage<User> page) {
        return userMapper.selectPage(page, null);
    }

    @Override
    public User selectUserByUsername(String username) {
        return userMapper.selectUserByName(username);
    }

    @Override
    public User selectUserAndGoodscardList(String username) {
        return userMapper.selectUserAndGoodscardList(username);
    }

}
