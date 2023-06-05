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
@ApiModel(value = "Users对象", description = "")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    @ApiModelProperty("�Ա�")
    private Integer gender;

    @ApiModelProperty("����¼ʱ��")
    private LocalDateTime lastlogintime;

    @ApiModelProperty("����¼IP")
    private String lastloginip;

    @ApiModelProperty("�û�����")
    private Integer userlevel;

    @ApiModelProperty("�ǳ�")
    private String nickname;

    private String mobile;

    @ApiModelProperty("ͷ��")
    private String avatar;

    private String weixinopenid;

    private String sessionkey;

    private String status;

    @ApiModelProperty("����ʱ��")
    private LocalDateTime addtime;

    private LocalDateTime updatetime;

    private Boolean deleted;


}
