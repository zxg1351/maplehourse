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
    private String m_banner_name;

    @Column(name = "m_banner_url")
    private String m_banner_url;

    @Column(name = "m_banner_type")
    private String m_banner_type;

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
}
