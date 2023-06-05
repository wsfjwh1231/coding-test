package com.example.testdemo.service.impl;

import com.example.testdemo.entity.Products;
import com.example.testdemo.mapper.ProductsMapper;
import com.example.testdemo.service.IProductsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品表 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products> implements IProductsService {

}
