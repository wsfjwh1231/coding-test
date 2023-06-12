package com.example.testdemo.mybatisPlusTest.service.impl;

import com.example.testdemo.mybatisPlusTest.entity.Goodscard;
import com.example.testdemo.mybatisPlusTest.mapper.GoodscardMapper;
import com.example.testdemo.mybatisPlusTest.service.IGoodscardService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 购物车 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Service
public class GoodscardServiceImpl extends ServiceImpl<GoodscardMapper, Goodscard> implements IGoodscardService {

    @Resource
    GoodscardMapper goodscardMapper;

    @Override
    public int selectGoodscardNum(int userId, int productId) {

        return goodscardMapper.selectCountNum(userId,productId);
    }

    @Override
    public List<Goodscard> selectGoodscardByUserIdAndProductId(int userId, int productId,int pageNo,int pageSize) {

        return goodscardMapper.selectGoodscardByUserIdAndProductId(userId, productId,pageNo,pageSize);
    }
}
