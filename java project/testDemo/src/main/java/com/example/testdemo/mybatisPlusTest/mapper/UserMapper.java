package com.example.testdemo.mybatisPlusTest.mapper;

import com.example.testdemo.mybatisPlusTest.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */

public interface UserMapper extends BaseMapper<User> {

//    根据姓名查询用户
    @Select("select * from user where username = #{username}")
    User selectUserByName(String username);

//    查询所有用户
    @Select("select * from user")
    List<User> selectUserList();



}
