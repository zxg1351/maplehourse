package com.zxg.maplehourse.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/16.
 */

@Data
@Entity
@Table(name = "m_user_menu")
public class MUserMenuModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Integer id;


    @Column(name = "m_user_id")
    private Integer mUserId;

    @Column(name = "m_menu_id")
    private Integer mMenuId;

    @Column(name = "create_user")
    private Integer createUser;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_user")
    private Integer updateUser;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "del_flag")
    private String delFlag;
}
