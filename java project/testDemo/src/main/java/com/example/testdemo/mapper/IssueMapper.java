package com.example.testdemo.mapper;

import com.example.testdemo.entity.Issue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 问题 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Mapper
public interface IssueMapper extends BaseMapper<Issue> {

}
