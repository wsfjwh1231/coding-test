package com.example.testdemo.mybatisPlusTest.service.impl;

import com.example.testdemo.mybatisPlusTest.entity.Issue;
import com.example.testdemo.mybatisPlusTest.mapper.IssueMapper;
import com.example.testdemo.mybatisPlusTest.service.IIssueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 问题 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Service
public class IssueServiceImpl extends ServiceImpl<IssueMapper, Issue> implements IIssueService {

}
