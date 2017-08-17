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
    private String t_work_name;
    @Column(name = "t_work_tel")
    private String t_work_tel;


    @Column(name = "t_work_type")
    private String t_work_type;
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
    @Column(name = "manager_Id")
    private Integer manager_Id;


    @Column(name = "t_work_address")
    private String t_work_address;
}
