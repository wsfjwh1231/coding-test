package com.example.testdemo.mapper;

import com.example.testdemo.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

}
