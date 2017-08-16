package com.zxg.maplehourse.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/8/16.
 */

@Data
@Entity
@Table(name = "t_department_super")
public class TDepartmentSuperModel

{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
}
