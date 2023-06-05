package com.example.testdemo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 货物
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Getter
@Setter
@ApiModel(value = "Goods对象", description = "货物")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String brief;

    private String picurl;

    @ApiModelProperty("是否新货物")
    private Boolean isnew;

    @ApiModelProperty("热门货物")
    private Boolean ishot;

    @ApiModelProperty("柜台价格")
    private Float counterprice;

    @ApiModelProperty("折扣价")
    private Float retailprice;

    private String channelid;

    private LocalDateTime addTime;

    @ApiModelProperty("分类ID")
    private String categoryid;

    @ApiModelProperty("关联货物ID")
    private String relategoodsid;

    @ApiModelProperty("品牌ID")
    private String brandid;

    @ApiModelProperty("分享链接")
    private String shareurl;

    private String unit;

    private Integer sortOrder;

    @ApiModelProperty("产品ID")
    private Integer productid;

    private LocalDateTime updateTime;

    private Boolean deleted;

    private Boolean isOnSale;


}
