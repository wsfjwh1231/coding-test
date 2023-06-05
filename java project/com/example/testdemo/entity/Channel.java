package com.example.testdemo.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 频道
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Getter
@Setter
@ApiModel(value = "Channel对象", description = "频道")
public class Channel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    @ApiModelProperty("图片地址")
    private String iconurl;


}
