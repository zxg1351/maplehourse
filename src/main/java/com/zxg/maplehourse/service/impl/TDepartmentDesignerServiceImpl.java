package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentDesignerModel;
import com.zxg.maplehourse.repository.TDepartmentDesignerRepository;
import com.zxg.maplehourse.service.TDepartmentDesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TDepartmentDesignerServiceImpl implements TDepartmentDesignerService {


    @Autowired
    private TDepartmentDesignerRepository tDepartmentDesignerRepository;

    @Override
    public ResultInfo selectAllTDepartmentDesigner() {

        ResultInfo resultInfo = new ResultInfo();
        List<TDepartmentDesignerModel> tDepartmentDesignerModelList = tDepartmentDesignerRepository.findAll();
        resultInfo.setAppData(tDepartmentDesignerModelList);
        return resultInfo;
    }
}
