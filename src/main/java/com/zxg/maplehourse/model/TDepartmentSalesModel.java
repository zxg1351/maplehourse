package com.zxg.maplehourse.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/16.
 */

@Data
@Entity
@Table(name = "t_department_sales")
public class TDepartmentSalesModel

{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Column(name = "sale_name")
    private String sale_name;
    @Column(name = "sale_type")
    private String sale_type;

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
    @Column(name = "m_user_id")
    private Integer m_user_id;
}
