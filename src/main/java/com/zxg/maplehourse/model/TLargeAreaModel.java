package com.zxg.maplehourse.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/16.
 */

@Data
@Entity
@Table(name = "t_large_area")
public class TLargeAreaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Column(name = "large_area_name")
    private String largeAreaName;
    @Column(name = "large_area_id")
    private Integer largeAreaId;

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
