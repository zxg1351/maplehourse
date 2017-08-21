package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentManagerModel;
import com.zxg.maplehourse.repository.TDepartmentManagerRepository;
import com.zxg.maplehourse.service.TDepartmentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TDepartmentManagerServiceImpl implements TDepartmentManagerService {


    @Autowired
    private TDepartmentManagerRepository tDepartmentManagerRepository;

    @Override
    public ResultInfo selectAllTDepartmentManager() {

        ResultInfo resultInfo = new ResultInfo();


        List<TDepartmentManagerModel> tDepartmentManagerModels = tDepartmentManagerRepository.findAll();


        resultInfo.setAppData(tDepartmentManagerModels);

        return resultInfo;
    }
}
