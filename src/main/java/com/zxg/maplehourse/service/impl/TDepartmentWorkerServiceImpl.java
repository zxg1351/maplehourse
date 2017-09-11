package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentWorkerModel;
import com.zxg.maplehourse.repository.TDepartmentWorkerRepository;
import com.zxg.maplehourse.service.TDepartmentWorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class TDepartmentWorkerServiceImpl implements TDepartmentWorkerService {
    private static final Logger logger = LoggerFactory.getLogger(TDepartmentWorkerServiceImpl.class);

    @Autowired
    private TDepartmentWorkerRepository workerRepository;


    @Override
    public ResultInfo saveWork(TDepartmentWorkerModel workerModel) {
        return null;
    }

    @Override
    public ResultInfo findById(Integer workId) {
        return null;
    }

    @Override
    public ResultInfo editWork(TDepartmentWorkerModel workerModel) {
        return null;
    }

    @Override
    public ResultInfo deleteWorkById(Integer workId) {
        return null;
    }

    @Override
    public ResultInfo selectAllTDepartmentWorker() {

        ResultInfo resultInfo = new ResultInfo();


        List<TDepartmentWorkerModel> tDepartmentWorkerModels = workerRepository.findAll();

        if (!CollectionUtils.isEmpty(tDepartmentWorkerModels)) {

            resultInfo.setAppData(tDepartmentWorkerModels);
            logger.debug("工人列表信息所示");
        } else {
            logger.debug("暂无工人列表信息");
        }
        return resultInfo;
    }

    @Override
    public Page<TDepartmentWorkerModel> selectPageWorker(Pageable pageNo) {

        Page<TDepartmentWorkerModel> pageable = workerRepository.findAll(pageNo);
        return pageable;
    }
}
