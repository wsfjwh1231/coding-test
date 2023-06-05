package com.example.testdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 货物陈列地址
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Getter
@Setter
@ApiModel(value = "Goodsgallery对象", description = "货物陈列地址")
public class Goodsgallery implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String goodsid;

    private String url;


}
