package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentWorkerModel;
import com.zxg.maplehourse.repository.TDepartmentWorkerRepository;
import com.zxg.maplehourse.service.TDepartmentWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TDepartmentWorkerServiceImpl implements TDepartmentWorkerService {
    @Autowired
    private TDepartmentWorkerRepository tDepartmentWorkerRepository;


    @Override
    public ResultInfo selectAllTDepartmentWorker() {

        ResultInfo resultInfo = new ResultInfo();
        List<TDepartmentWorkerModel> tDepartmentWorkerModels = tDepartmentWorkerRepository.findAll();

        resultInfo.setAppData(tDepartmentWorkerModels);

        return resultInfo;
    }
}
