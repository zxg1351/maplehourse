package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentManagerModel;
import com.zxg.maplehourse.repository.TDepartmentManagerRepository;
import com.zxg.maplehourse.service.TDepartmentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class TDepartmentManagerServiceImpl implements TDepartmentManagerService {


    @Autowired
    private TDepartmentManagerRepository managerRepository;


    @Override
    public ResultInfo selectAllTDepartmentManager() {

        ResultInfo resultInfo = new ResultInfo();

        List<TDepartmentManagerModel> managerModelList = managerRepository.findAll();

        if (!CollectionUtils.isEmpty(managerModelList)) {


            resultInfo.setAppData(managerModelList);
        } else {

            resultInfo.setAppData("");
        }

        return resultInfo;
    }
}
