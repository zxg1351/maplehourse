package com.zxg.maplehourse.service;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MMenuModel;
import com.zxg.maplehourse.model.MResetPsdModel;
import com.zxg.maplehourse.model.MUserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Administrator on 2017/8/18.
 */
public interface MUserService {



    ResultInfo selectAllUser();


    ResultInfo saveUser(MUserModel mUserModel);

    ResultInfo checkUser(MUserModel mUserModel);

    Page<MUserModel> selectPageUser(Pageable pageable);

    ResultInfo findById(Integer id);

    ResultInfo updateUser(MUserModel mUserModel);

    Page<MUserModel> selectUser(MUserModel mUserModel);

    ResultInfo delUserById(Integer id);

    ResultInfo resetPsdModal(MResetPsdModel mResetPsdModel);
}
