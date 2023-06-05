package com.example.testdemo.service.impl;

import com.example.testdemo.entity.Address;
import com.example.testdemo.mapper.AddressMapper;
import com.example.testdemo.service.IAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 地址表 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

}
