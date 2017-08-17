package com.zxg.maplehourse.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/16.
 */

@Data
@Entity
@Table(name = "t_department_worker")
public class TDepartmentWorkerModel

{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "t_work_name")
    private String tWorkName;
    @Column(name = "t_work_tel")
    private String tWorkTel;


    @Column(name = "t_work_type")
    private String tWorkType;


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
    @Column(name = "manager_Id")
    private Integer manager_Id;


    @Column(name = "t_work_address")
    private String tWorkAddress;
}
