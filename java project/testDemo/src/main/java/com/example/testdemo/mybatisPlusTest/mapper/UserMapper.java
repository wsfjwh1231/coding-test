package com.example.testdemo.mybatisPlusTest.mapper;

import com.example.testdemo.mybatisPlusTest.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

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


    @Select("Select * " +
            "From user " +
            "Where username = #{userName}")
    @Results({
            @Result(column = "id",property = "goodscardList",
                    many = @Many(select = "com.example.testdemo.mybatisPlusTest.mapper.GoodscardMapper.selectGoodscardByUserId")),
            @Result(column = "username",property = "username"),
            @Result(column = "mobile",property = "mobile"),
            @Result(column = "avatar",property = "avatar"),
            @Result(column = "nickname",property = "nickname")
    })
    User selectUserAndGoodscardList(String userName);


    @Select("select * " +
            "from user " +
            "where username = #{username}")
    @Results({
            @Result(column = "user_name",property ="username")
    })
    User testlog(String tete);

}
