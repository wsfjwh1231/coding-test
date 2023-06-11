package com.example.testdemo.mybatisPlusTest.service.impl;

import com.example.testdemo.mybatisPlusTest.entity.Comment;
import com.example.testdemo.mybatisPlusTest.mapper.CommentMapper;
import com.example.testdemo.mybatisPlusTest.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 货物评论 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
