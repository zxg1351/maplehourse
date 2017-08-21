package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MUserModel;
import com.zxg.maplehourse.repository.MUserRepository;
import com.zxg.maplehourse.service.MUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MUserServiceImpl implements MUserService {


    @Autowired
    private MUserRepository mUserRepository;

    @Override
    public ResultInfo selectAllUser() {

        ResultInfo resultInfo = new ResultInfo();

        List<MUserModel> mUserModelList =mUserRepository.findAll();

        resultInfo.setAppData(mUserModelList);

        return resultInfo;
    }
}
