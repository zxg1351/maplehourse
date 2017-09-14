package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentDesignerModel;
import com.zxg.maplehourse.model.TDepartmentFinanceModel;
import com.zxg.maplehourse.repository.TDepartmentFinanceRepository;
import com.zxg.maplehourse.service.TDepartmentFinanceService;
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
public class TDepartmentFinanceServiceImpl implements TDepartmentFinanceService {

    private static final Logger logger = LoggerFactory.getLogger(TDepartmentFinanceServiceImpl.class);

    @Autowired
    private TDepartmentFinanceRepository departmentFinanceRepository;

    @Override
    public ResultInfo selectAllTDepartmentFinance() {


        ResultInfo resultInfo = new ResultInfo();
        List<TDepartmentFinanceModel> financeModelList = departmentFinanceRepository.findAll();


        if (!CollectionUtils.isEmpty(financeModelList)) {

            resultInfo.setAppData(financeModelList);
            logger.debug("财务列表信息显示");
        } else {

            logger.debug("暂无财务列表信息显示");
        }
        return resultInfo;
    }

    @Override
    public Page<TDepartmentFinanceModel> selectPageFinance(Pageable pageable) {

        Page<TDepartmentFinanceModel> modelPage = departmentFinanceRepository.findByDelFlag("0", pageable);

        return modelPage;
    }

    @Override
    public ResultInfo saveDesigner(TDepartmentFinanceModel tDepartmentFinanceModel) {

        tDepartmentFinanceModel.setCreateTime(new Date());
        tDepartmentFinanceModel.setCreateUser(1);
        tDepartmentFinanceModel.setDelFlag("0");
        TDepartmentFinanceModel financeModel = departmentFinanceRepository.save(tDepartmentFinanceModel);
        ResultInfo resultInfo = new ResultInfo();

        resultInfo.setAppData(financeModel);
        resultInfo.setResultMessage("保存成功");
        resultInfo.setResultCode("0");
        return resultInfo;
    }

    @Override
    public ResultInfo findById(Integer financeId) {
        ResultInfo resultInfo = new ResultInfo();

        TDepartmentFinanceModel financeModel = departmentFinanceRepository.findOne(financeId);
        resultInfo.setAppData(financeModel);
        return resultInfo;
    }

    @Override
    public ResultInfo editFinance(TDepartmentFinanceModel tDepartmentFinanceModel) {
        ResultInfo resultInfo = new ResultInfo();

        int result = departmentFinanceRepository.editFinance(1, new Date(), tDepartmentFinanceModel.getName(), tDepartmentFinanceModel.getId());

        resultInfo.setAppData(result);
        resultInfo.setResultMessage("修改成功");
        resultInfo.setResultCode("success");

        return resultInfo;
    }

    @Override
    public ResultInfo deleteRoleById(Integer financeId) {
        ResultInfo resultInfo = new ResultInfo();
        int result = departmentFinanceRepository.deleteFinanceById(1, new Date(), "1", financeId);
        resultInfo.setAppData(result);
        resultInfo.setResultMessage("删除成功");
        resultInfo.setResultCode("success");
        return resultInfo;
    }

    @Override
    public Page<TDepartmentFinanceModel> selectFinance(TDepartmentFinanceModel model) {
        Page<TDepartmentFinanceModel> modelPage = departmentFinanceRepository.findAll(new Specification() {
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
