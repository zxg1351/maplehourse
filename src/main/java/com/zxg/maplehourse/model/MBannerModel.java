package com.zxg.maplehourse.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/16.
 */

@Data
@Entity
@Table(name = "m_banner")
public class MBannerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "m_banner_name")
    private String mBannerName;

    @Column(name = "m_banner_url")
    private String mBannerUrl;

    @Column(name = "m_banner_type")
    private String mBannerType;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user")
    private Integer createUser;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "update_user")
    private Integer updateUser;

    @Column(name = "del_flag")
    private String delFlag;
}
