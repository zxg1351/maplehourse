package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentDesignerModel;
import com.zxg.maplehourse.model.TDepartmentFinanceModel;
import com.zxg.maplehourse.model.TDepartmentFundesignerModel;
import com.zxg.maplehourse.repository.TDepartmentFundesignerRepository;
import com.zxg.maplehourse.service.TDepartmentFundesignerService;
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
public class TDepartmentFundesignerServiceImpl implements TDepartmentFundesignerService {

    private static final Logger logger = LoggerFactory.getLogger(TDepartmentFundesignerServiceImpl.class);
    @Autowired
    private TDepartmentFundesignerRepository fundesignerRepository;

    @Override
    public ResultInfo selectAllTDepartmentFundesigner() {

        ResultInfo resultInfo = new ResultInfo();

        List<TDepartmentFundesignerModel> fundesignerModelList = fundesignerRepository.findAll();

        if (!CollectionUtils.isEmpty(fundesignerModelList)) {


            resultInfo.setAppData(fundesignerModelList);
            logger.debug("家具设计师列表信息显示");
        } else {
            logger.debug("暂无家具设计师列表显示");
        }
        return resultInfo;
    }

    @Override
    public Page<TDepartmentFundesignerModel> selectPageFundesigner(Pageable pageable) {

        Page<TDepartmentFundesignerModel> modelPage = fundesignerRepository.findByDelFlag("0",pageable);
        return modelPage;
    }

    @Override
    public ResultInfo saveFundesigner(TDepartmentFundesignerModel fundesignerModel) {

        fundesignerModel.setCreateTime(new Date());
        fundesignerModel.setCreateUser(1);
        fundesignerModel.setDelFlag("0");
        TDepartmentFundesignerModel fundesignerModel1 = fundesignerRepository.save(fundesignerModel);
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setAppData(fundesignerModel1);
        resultInfo.setResultMessage("保存成功");
        resultInfo.setResultCode("0");
        return resultInfo;
    }

    @Override
    public ResultInfo findById(Integer fundesignerId) {
        ResultInfo resultInfo = new ResultInfo();

        TDepartmentFundesignerModel fundesignerModel = fundesignerRepository.findOne(fundesignerId);
        resultInfo.setAppData(fundesignerModel);
        return resultInfo;
    }

    @Override
    public ResultInfo editFundesigner(TDepartmentFundesignerModel fundesignerModel) {
        ResultInfo resultInfo = new ResultInfo();

        int result = fundesignerRepository.editFundesigner(1, new Date(), fundesignerModel.getName(), fundesignerModel.getType(), fundesignerModel.getId());
        resultInfo.setAppData(result);
        resultInfo.setResultMessage("修改成功");
        resultInfo.setResultCode("success");
        return resultInfo;
    }

    @Override
    public ResultInfo deleteFundesignerById(Integer fundesignerId) {
        ResultInfo resultInfo = new ResultInfo();
        int result = fundesignerRepository.deleteFundesignerById(1, new Date(), "1", fundesignerId);
        resultInfo.setAppData(result);
        resultInfo.setResultMessage("删除成功");
        resultInfo.setResultCode("success");
        return resultInfo;
    }

    @Override
    public Page<TDepartmentFundesignerModel> selectFundesigner(TDepartmentFundesignerModel model) {
        Page<TDepartmentFundesignerModel> modelPage = fundesignerRepository.findAll(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Expression<String> name = root.get("name").as(String.class);
                Expression<String> delFlag = root.get("delFlag").as(String.class);
                criteriaQuery.where(criteriaBuilder.like(name, "%" + model.getName() + "%"),
                        criteriaBuilder.equal(delFlag, "0")
                );
                return null;
            }
        }, new PageRequest(0, 10));
        return modelPage;
    }
}
