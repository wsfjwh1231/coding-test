package com.example.testdemo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 分类信息表
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Getter
@Setter
@ApiModel(value = "Category对象", description = "分类信息表")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String keywords;

    private String desc;

    @ApiModelProperty("与商品id关联")
    private String pid;

    private String iconurl;

    private String picurl;

    private String level;

    private Integer sortorder;

    private LocalDateTime addtime;

    private LocalDateTime updatetime;

    private Boolean deleted;


}
