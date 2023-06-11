package com.example.testdemo.mybatisPlusTest.service.impl;

import com.example.testdemo.mybatisPlusTest.entity.Topic;
import com.example.testdemo.mybatisPlusTest.mapper.TopicMapper;
import com.example.testdemo.mybatisPlusTest.service.ITopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 主题 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements ITopicService {

}
