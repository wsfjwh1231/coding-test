package com.example.testdemo.service.impl;

import com.example.testdemo.entity.Channel;
import com.example.testdemo.mapper.ChannelMapper;
import com.example.testdemo.service.IChannelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 频道 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Service
public class ChannelServiceImpl extends ServiceImpl<ChannelMapper, Channel> implements IChannelService {

}
