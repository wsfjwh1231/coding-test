package com.example.testdemo.mybatisPlusTest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>
 * 
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Data
@TableName("user")
@ApiModel(value = "User",description = "用户实体类")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    @ApiModelProperty("性别")
    private Integer gender;

    @ApiModelProperty("最后登录时间")
    private LocalDateTime lastlogintime;

    @ApiModelProperty("最后登录IP")
    private String lastloginip;

    @ApiModelProperty(value = "用户级别",example = "1")
    private Integer userlevel;

    @ApiModelProperty("昵称")
    private String nickname;

    private String mobile;

    @ApiModelProperty("头像")
    private String avatar;

    private String weixinopenid;

    private String sessionkey;

    private String status;

    @ApiModelProperty("建立时间")
    private LocalDateTime addtime;

    private LocalDateTime updatetime;

    private Boolean deleted;



}
