package com.zxg.maplehourse.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/8/16.
 */
@Data
@Entity
@Table(name = "m_city")
public class MCityModel
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Column(name = "m_city_id")
    private String mCityId;

    @Column(name = "m_city_name")
    private String mCityName;

    @Column(name = "m_province_id")
    private Integer mProvinceId;
}
