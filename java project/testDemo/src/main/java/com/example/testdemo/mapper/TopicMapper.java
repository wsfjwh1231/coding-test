package com.example.testdemo.mapper;

import com.example.testdemo.entity.Topic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 主题 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Mapper
public interface TopicMapper extends BaseMapper<Topic> {

}
