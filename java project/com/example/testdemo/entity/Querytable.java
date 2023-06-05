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
 * 搜索页信息
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Getter
@Setter
@ApiModel(value = "Querytable对象", description = "搜索页信息")
public class Querytable implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String keyword;

    private String url;

    private Boolean ishot;

    private Boolean isdefault;

    private Integer sortorder;

    private LocalDateTime addtime;

    private LocalDateTime updatetime;

    private Boolean deleted;


}
