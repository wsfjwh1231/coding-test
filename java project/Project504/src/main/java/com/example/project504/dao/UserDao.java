package com.example.project504.dao;

import com.example.project504.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-04 15:20:30
 */
@Mapper
public interface UserDao {

    /**
     * 登录
     *
     * @return 实例对象
     */
    @Select("select * from user " +
            "where " +
            "username = #{username} And password = #{password}")
    User queryByUser(User user);

    /**
     * 查询指定行数据
     *
     * @param user     查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<User> queryAllByLimit(User user, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param user 查询条件
     * @return 总行数
     */
    long count(User user);

    /**
     * 注册
     *
     * @param user 实例对象
     * @return 影响行数
     */
    @Insert("INSERT INTO user" +
            " (id,username,password,phone,avatar) " +
            "VALUES" +
            " (#{id},#{username},#{password},#{phone},#{avatar})")
    int addUser(User user);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<User> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<User> entities);

    /**
     * 修改用户
     *
     * @return 结果
     */
    @Update("UPDATE user " +
            "SET " +
            "username = #{username}," +
            "password = #{password}," +
            "phone = #{phone}" +
            "where " +
            "id = #{id}")
    int editUser(User user);

    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user " +
            "where " +
            "username = #{username}")
    User findByUsername(String username);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Delete("delete from user " +
            "where " +
            "id = #{id}")
    int deleteById(String id);

}

