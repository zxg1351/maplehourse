package com.zxg.maplehourse.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/8/16.
 */
@Data
@Entity
@Table(name = "m_user_role")
public class MUserRoleModel


{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
}

