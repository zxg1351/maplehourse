package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentDesignerModel;
import com.zxg.maplehourse.model.TDepartmentWorkerModel;
import com.zxg.maplehourse.repository.TDepartmentWorkerRepository;
import com.zxg.maplehourse.service.TDepartmentWorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

@Service
public class TDepartmentWorkerServiceImpl implements TDepartmentWorkerService {
    private static final Logger logger = LoggerFactory.getLogger(TDepartmentWorkerServiceImpl.class);

    @Autowired
    private TDepartmentWorkerRepository workerRepository;


    @Override
    public ResultInfo saveWork(TDepartmentWorkerModel workerModel) {
        workerModel.setCreateTime(new Date());
        workerModel.setCreateUser(1);
        workerModel.setDelFlag("0");
        TDepartmentWorkerModel model = workerRepository.save(workerModel);
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setAppData(model);
        resultInfo.setResultMessage("保存成功");
        resultInfo.setResultCode("0");
        return resultInfo;
    }

    @Override
    public ResultInfo findById(Integer workId) {
        ResultInfo resultInfo = new ResultInfo();

        TDepartmentWorkerModel model = workerRepository.findOne(workId);
        resultInfo.setAppData(model);
        return resultInfo;
    }

    @Override
    public ResultInfo editWork(TDepartmentWorkerModel workerModel) {
        ResultInfo resultInfo = new ResultInfo();

        int result = workerRepository.editWorker(1, new Date(), workerModel.getTWorkName(), workerModel.getTWorkTel(),
                workerModel.getTWorkAddress(), workerModel.getTWorkType(), workerModel.getId());
        resultInfo.setAppData(result);
        resultInfo.setResultMessage("修改成功");
        resultInfo.setResultCode("success");
        return resultInfo;
    }

    @Override
    public ResultInfo deleteWorkById(Integer workId) {
        ResultInfo resultInfo = new ResultInfo();
        int result = workerRepository.deleteWorkerById(1, new Date(), "1", workId);
        resultInfo.setAppData(result);
        resultInfo.setResultMessage("删除成功");
        resultInfo.setResultCode("success");
        return resultInfo;
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

        Page<TDepartmentWorkerModel> pageable = workerRepository.findByDelFlag("0",pageNo);
        return pageable;
    }

    @Override
    public Page<TDepartmentWorkerModel> selectWorker(TDepartmentWorkerModel model) {
        Page<TDepartmentWorkerModel> modelPage = workerRepository.findAll(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Expression<String> tWorkName = root.get("tWorkName").as(String.class);
                Expression<String> delFlag = root.get("delFlag").as(String.class);
                criteriaQuery.where(criteriaBuilder.like(tWorkName, "%" + model.getTWorkName() + "%"),
                        criteriaBuilder.equal(delFlag, "0")
                );
                return null;
            }
        }, new PageRequest(0, 10));
        return modelPage;
    }
}
