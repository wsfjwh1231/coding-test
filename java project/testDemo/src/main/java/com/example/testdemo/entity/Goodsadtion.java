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
 * 货物附加表
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Getter
@Setter
@ApiModel(value = "Goodsadtion对象", description = "货物附加表")
public class Goodsadtion implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("货物ID")
    private String goodsid;

    private String keywords;

    private String detail;


}
