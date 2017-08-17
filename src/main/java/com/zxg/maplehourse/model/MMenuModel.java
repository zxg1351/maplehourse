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
    private String m_menu_number;

    @Column(name = "m_menu_name")
    private String m_menu_name;

    @Column(name = "create_user")
    private Integer create_user;

    @Column(name = "create_time")
    private Date create_time;

    @Column(name = "update_user")
    private Integer update_user;

    @Column(name = "update_time")
    private Date update_time;

    @Column(name = "del_flag")
    private String del_flag;
}
