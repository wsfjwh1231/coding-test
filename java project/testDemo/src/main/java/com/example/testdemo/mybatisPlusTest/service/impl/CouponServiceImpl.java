package com.example.testdemo.mybatisPlusTest.service.impl;

import com.example.testdemo.mybatisPlusTest.entity.Coupon;
import com.example.testdemo.mybatisPlusTest.mapper.CouponMapper;
import com.example.testdemo.mybatisPlusTest.service.ICouponService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 优惠券 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements ICouponService {

}
