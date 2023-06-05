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
 * 货物评论
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Getter
@Setter
@ApiModel(value = "Comment对象", description = "货物评论")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime addtime;

    private String admincontent;

    private String nickname;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("头像")
    private String avatar;

    private String content;

    private String goodsid;


}
