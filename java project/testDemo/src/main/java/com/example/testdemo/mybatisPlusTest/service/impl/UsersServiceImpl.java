package com.example.testdemo.mybatisPlusTest.service.impl;

import com.example.testdemo.mybatisPlusTest.entity.Users;
import com.example.testdemo.mybatisPlusTest.mapper.UsersMapper;
import com.example.testdemo.mybatisPlusTest.service.IUsersService;
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
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
