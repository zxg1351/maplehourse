package com.zxg.maplehourse.model;


import lombok.Data;

import javax.persistence.Entity;

@Data
public class MResetPsdModel {

    private Integer id;

    private String oldPassword;//旧密码

    private String newPassword;//新密码

    private String confirmPassword;//确认密码

}
