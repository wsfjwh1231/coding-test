package com.example.testdemo.mybatisPlusTest.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 品牌
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Getter
@Setter
@ApiModel(value = "Brand对象", description = "品牌")
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String desc;

    private String picurl;

    private Float floorprice;

    private Integer sortorder;

    private LocalDateTime addtime;

    private LocalDateTime updatetime;

    private Boolean deleted;


}
