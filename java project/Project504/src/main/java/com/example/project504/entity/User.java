package com.example.project504.entity;



import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2023-05-04 15:20:31
 */
@Data
@Entity
public class User extends BaseEntity {

    private String avatar;

    private String username;

    private String password;

    private String phone;

    @Temporal(TemporalType.DATE)
    private Date updateTime;

    @Temporal(TemporalType.DATE)
    private Date createTime;

}

