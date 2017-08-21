package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentFundesignerModel;
import com.zxg.maplehourse.repository.TDepartmentFundesignerRepository;
import com.zxg.maplehourse.service.TDepartmentFundesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TDepartmentFundesignerServiceImpl implements TDepartmentFundesignerService {

    @Autowired
    private TDepartmentFundesignerRepository fundesignerRepository;

    @Override
    public ResultInfo selectAllTDepartmentFundesigner() {
        ResultInfo resultInfo = new ResultInfo();


        List<TDepartmentFundesignerModel> fundesignerModelList = fundesignerRepository.findAll();

        resultInfo.setAppData(fundesignerModelList);
        return resultInfo;
    }
}
