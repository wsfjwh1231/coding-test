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
 * 
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Getter
@Setter
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
