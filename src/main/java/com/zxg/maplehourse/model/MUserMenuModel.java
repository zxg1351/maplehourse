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
    private Integer m_user_id;

    @Column(name = "m_menu_id")
    private Integer m_menu_id;

    @Column(name = "create_user")
    private Integer create_user;

    @Column(name = "create_time")
    private Date create_time;

    @Column(name = "update_time")
    private Date update_time;

    @Column(name = "update_user")
    private Date update_user;

    @Column(name = "del_flag")
    private String del_flag;
}
