package com.example.testdemo.mybatisPlusTest.service;

import com.example.testdemo.mybatisPlusTest.entity.Goodscard;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 购物车 服务类
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
public interface IGoodscardService extends IService<Goodscard> {

    int selectGoodscardNum(int userId, int productId);

    List<Goodscard> selectGoodscardByUserIdAndProductId(int userId, int productId,int pageNo,int pageSize);
}
