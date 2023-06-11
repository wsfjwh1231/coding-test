package com.example.testdemo.mybatisPlusTest.entity;

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
 * 规格
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Getter
@Setter
@ApiModel(value = "Specifications对象", description = "规格")
public class Specifications implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String goodsid;

    @ApiModelProperty("规格")
    private String specification;

    @ApiModelProperty("标准")
    private String value;

    private String picurl;

    private LocalDateTime addtime;

    private LocalDateTime updatetime;

    private Boolean deleted;


}
