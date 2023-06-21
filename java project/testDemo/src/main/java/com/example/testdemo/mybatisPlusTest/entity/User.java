package com.example.testdemo.mybatisPlusTest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * <p>
 * 
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Data
//@Accessors(chain = true)
//@TableName("user")
@ApiModel("用户实体类")
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11)")

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;

    @ApiModelProperty(value = "性别",required = true)
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


    @Transient
    @TableField(exist = false)
    @ApiModelProperty(hidden = true)
    private List<Goodscard> goodscardList;



}
