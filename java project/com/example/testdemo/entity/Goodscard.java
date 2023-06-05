package com.example.testdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 购物车
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Getter
@Setter
@ApiModel(value = "Goodscard对象", description = "购物车")
public class Goodscard implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private String goodsId;

    @ApiModelProperty("产品品编号")
    private Integer productId;

    @ApiModelProperty("数量")
    private Integer number;

    @ApiModelProperty("是否选中")
    private Boolean checked;

    private LocalDateTime addtime;

    private LocalDateTime updatetime;

    private Boolean deleted;


}
