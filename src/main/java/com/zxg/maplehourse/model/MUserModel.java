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
    private String mUserName;
    ;
    @Column(name = "wx_open_id")
    private String wxOpenId;
    @Column(name = "wb_open_id")
    private String wbOpenId;
    @Column(name = "qq_open_id")
    private String qqOpenId;
    @Column(name = "m_user_tel")
    private String mUserTel;
    @Column(name = "m_user_account")
    private String mUserAccount;
    @Column(name = "m_user_password")
    private String mUserPassword;
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
    @Column(name = "m_user_imageUrl")
    private String mUserImageUrl;


}
