package com.example.testdemo.mybatisPlusTest.mapper;

import com.example.testdemo.mybatisPlusTest.entity.Goodscard;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 购物车 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */

public interface GoodscardMapper extends BaseMapper<Goodscard> {

//    根据用户id查询购物车
    @Select("select * " +
            "from goodscard " +
            "where userId = #{userId}")
    List<Goodscard> selectGoodscardByUserId(int userId);


//    分页查询
    @Select("select * " +
            "from goodscard " +
            "where userId = #{userId} and product_id = #{productId} " +
            "limit #{pageNo},#{pageSize}")
    List<Goodscard> selectGoodscardByUserIdAndProductId(int userId,int productId,int pageNo,int pageSize);

//    查询所有数据总数
    @Select("select count(*) " +
            "from goodscard " +
            "where userId = #{userId} and product_id = #{productId} ")
    int selectCountNum(int userId,int productId);
}
