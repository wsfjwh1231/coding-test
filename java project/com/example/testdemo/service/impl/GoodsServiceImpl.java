package com.example.testdemo.service.impl;

import com.example.testdemo.entity.Goods;
import com.example.testdemo.mapper.GoodsMapper;
import com.example.testdemo.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 货物 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

}
