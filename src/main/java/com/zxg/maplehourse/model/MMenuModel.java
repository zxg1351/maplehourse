package com.zxg.maplehourse.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/16.
 */

@Data
@Entity
@Table(name = "m_menu")
public class MMenuModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "m_menu_number")
    private String mMenuNumber;

    @Column(name = "m_menu_name")
    private String mMenuName;

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
