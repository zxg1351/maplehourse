package com.zxg.maplehourse.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/8/16.
 */

@Data
@Entity
@Table(name = "m_province")
public class MProvinceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "province_id")
    private String provinceId;


    @Column(name = "m_province_name")
    private String mProvinceName;
}
