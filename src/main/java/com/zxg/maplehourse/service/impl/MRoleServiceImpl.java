package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MRoleModel;
import com.zxg.maplehourse.repository.MRoleRepository;
import com.zxg.maplehourse.service.MRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


@Service
public class MRoleServiceImpl implements MRoleService {


    @Autowired
    private MRoleRepository mRoleRepository;

    @Override
    public ResultInfo selectAllRole() {



        ResultInfo resultInfo = new ResultInfo();

        List<MRoleModel> mRoleModelList = mRoleRepository.findAll();

        if (!CollectionUtils.isEmpty(mRoleModelList)){

            resultInfo.setAppData(mRoleModelList);
        }else {

            resultInfo.setAppData("");
        }
        return resultInfo;
    }
}
