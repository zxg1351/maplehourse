package com.zxg.maplehourse.service;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MUserModel;

import java.util.List;

/**
 * Created by Administrator on 2017/8/18.
 */
public interface MUserService {



    ResultInfo selectAllUser();


    ResultInfo saveUser(MUserModel mUserModel);


    ResultInfo checkUser(MUserModel mUserModel);
}
