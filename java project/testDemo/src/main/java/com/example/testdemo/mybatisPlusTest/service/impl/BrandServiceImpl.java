package com.example.testdemo.mybatisPlusTest.service.impl;

import com.example.testdemo.mybatisPlusTest.entity.Brand;
import com.example.testdemo.mybatisPlusTest.mapper.BrandMapper;
import com.example.testdemo.mybatisPlusTest.service.IBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 品牌 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

}
