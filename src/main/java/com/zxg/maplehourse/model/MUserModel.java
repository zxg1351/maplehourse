package com.zxg.maplehourse.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/16.
 */
@Data
@Entity
@Table(name = "m_user")
public class MUserModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "m_user_name")
    private String m_user_name;
    ;
    @Column(name = "wx_open_id")
    private String wx_open_id;
    @Column(name = "wb_open_id")
    private String wb_open_id;
    @Column(name = "qq_open_id")
    private String qq_open_id;
    @Column(name = "m_user_tel")
    private String m_user_tel;
    @Column(name = "m_user_account")
    private String m_user_account;
    @Column(name = "m_user_password")
    private String m_user_password;
    @Column(name = "create_time")
    private Date create_time;
    @Column(name = "create_user")
    private Integer create_user;
    @Column(name = "update_time")
    private Date update_time;
    @Column(name = "update_user")
    private Integer update_user;
    @Column(name = "del_flag")
    private String del_flag;
    @Column(name = "m_user_imageUrl")
    private String m_user_imageUrl;


}
