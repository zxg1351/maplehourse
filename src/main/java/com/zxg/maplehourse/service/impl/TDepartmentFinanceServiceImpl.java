package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentFinanceModel;
import com.zxg.maplehourse.repository.TDepartmentFinanceRepository;
import com.zxg.maplehourse.service.TDepartmentFinanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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

        Page<TDepartmentFinanceModel> modelPage = departmentFinanceRepository.findAll(pageable);

        return modelPage;
    }

    @Override
    public ResultInfo saveDesigner(TDepartmentFinanceModel tDepartmentFinanceModel) {
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
    public ResultInfo editFinance(TDepartmentFinanceModel tDepartmentDesignerModel) {
        ResultInfo resultInfo = new ResultInfo();

        int result = departmentFinanceRepository.editFinance(1, new Date(), tDepartmentDesignerModel.getName(), tDepartmentDesignerModel.getId());

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
}
