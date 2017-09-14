package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentDesignerModel;
import com.zxg.maplehourse.repository.TDepartmentDesignerRepository;
import com.zxg.maplehourse.service.TDepartmentDesignerService;
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
public class TDepartmentDesignerServiceImpl implements TDepartmentDesignerService {

    private static final Logger logger = LoggerFactory.getLogger(TDepartmentDesignerServiceImpl.class);

    @Autowired
    private TDepartmentDesignerRepository tDepartmentDesignerRepository;

    @Override
    public ResultInfo selectAllTDepartmentDesigner() {

        ResultInfo resultInfo = new ResultInfo();

        List<TDepartmentDesignerModel> departmentDesignerModelList = tDepartmentDesignerRepository.findAll();


        if (!CollectionUtils.isEmpty(departmentDesignerModelList)) {

            resultInfo.setAppData(departmentDesignerModelList);
            logger.debug("设计师列表信息显示");
        } else {

            logger.debug("暂无设计师列表显示");
        }
        return resultInfo;
    }

    @Override
    public Page<TDepartmentDesignerModel> selectPageDesigner(Pageable pageable) {

        Page<TDepartmentDesignerModel> modelPage = tDepartmentDesignerRepository.findByDelFlag("0",pageable);


        return modelPage;
    }

    @Override
    public ResultInfo saveDesigner(TDepartmentDesignerModel tDepartmentDesignerModel) {

        ResultInfo resultInfo = new ResultInfo();
        tDepartmentDesignerModel.setCreateTime(new Date());
        tDepartmentDesignerModel.setCreateUser(1);
        tDepartmentDesignerModel.setDelFlag("0");
        TDepartmentDesignerModel designerModel = tDepartmentDesignerRepository.save(tDepartmentDesignerModel);

        resultInfo.setAppData(designerModel);
        resultInfo.setResultCode("0");
        resultInfo.setResultMessage("新建成功");


        return resultInfo;
    }

    @Override
    public ResultInfo findById(Integer designerId) {
        ResultInfo resultInfo = new ResultInfo();

        TDepartmentDesignerModel financeModel = tDepartmentDesignerRepository.findOne(designerId);
        resultInfo.setAppData(financeModel);
        return resultInfo;
    }

    @Override
    public ResultInfo editDesigner(TDepartmentDesignerModel tDepartmentDesignerModel) {
        ResultInfo resultInfo = new ResultInfo();

        int result = tDepartmentDesignerRepository.editDesigner(1, new Date(), tDepartmentDesignerModel.getName(), tDepartmentDesignerModel.getType(), tDepartmentDesignerModel.getId());

        resultInfo.setAppData(result);
        resultInfo.setResultMessage("修改成功");
        resultInfo.setResultCode("success");

        return resultInfo;
    }

    @Override
    public ResultInfo deleteDesignerById(Integer designerId) {
        ResultInfo resultInfo = new ResultInfo();
        int result = tDepartmentDesignerRepository.deleteDesignerById(1, new Date(), "1", designerId);
        resultInfo.setAppData(result);
        resultInfo.setResultMessage("删除成功");
        resultInfo.setResultCode("success");
        return resultInfo;
    }

    @Override
    public Page<TDepartmentDesignerModel> selectDesigner(TDepartmentDesignerModel model) {

        Page<TDepartmentDesignerModel> modelPage = tDepartmentDesignerRepository.findAll(new Specification() {
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
