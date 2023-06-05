package com.example.testdemo.service.impl;

import com.example.testdemo.entity.Category;
import com.example.testdemo.mapper.CategoryMapper;
import com.example.testdemo.service.ICategoryService;
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
