package com.example.testdemo.mybatisPlusTest.service.impl;

import com.example.testdemo.mybatisPlusTest.entity.Category;
import com.example.testdemo.mybatisPlusTest.mapper.CategoryMapper;
import com.example.testdemo.mybatisPlusTest.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 分类信息表 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
