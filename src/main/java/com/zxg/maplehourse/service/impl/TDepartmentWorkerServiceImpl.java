package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentWorkerModel;
import com.zxg.maplehourse.repository.TDepartmentWorkerRepository;
import com.zxg.maplehourse.service.TDepartmentWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class TDepartmentWorkerServiceImpl implements TDepartmentWorkerService {


    @Autowired
    private TDepartmentWorkerRepository workerRepository;


    @Override
    public ResultInfo selectAllTDepartmentWorker() {

        ResultInfo resultInfo = new ResultInfo();


        List<TDepartmentWorkerModel> tDepartmentWorkerModels = workerRepository.findAll();

        if (!CollectionUtils.isEmpty(tDepartmentWorkerModels)) {

            resultInfo.setAppData(tDepartmentWorkerModels);
        } else {
            resultInfo.setAppData("");
        }
        return resultInfo;
    }
}
