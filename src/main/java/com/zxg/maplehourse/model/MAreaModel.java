package com.zxg.maplehourse.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/8/16.
 */

@Data
@Entity
@Table(name = "m_area")
public class MAreaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "m_area_id")
    private String mAreaId;


    @Column(name = "m_area_name")
    private String mAreaName;

    @Column(name = "m_city_id")
    private String mCityId;
}
