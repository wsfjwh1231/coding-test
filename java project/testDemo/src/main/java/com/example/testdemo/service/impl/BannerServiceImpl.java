package com.example.testdemo.service.impl;

import com.example.testdemo.entity.Banner;
import com.example.testdemo.mapper.BannerMapper;
import com.example.testdemo.service.IBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 广告 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements IBannerService {

}
