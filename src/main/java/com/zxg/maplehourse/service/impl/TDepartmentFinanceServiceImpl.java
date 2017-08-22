package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentFinanceModel;
import com.zxg.maplehourse.repository.TDepartmentFinanceRepository;
import com.zxg.maplehourse.service.TDepartmentFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class TDepartmentFinanceServiceImpl implements TDepartmentFinanceService {

    @Autowired
    private TDepartmentFinanceRepository departmentFinanceRepository;

    @Override
    public ResultInfo selectAllTDepartmentFinance() {


        ResultInfo resultInfo = new ResultInfo();
        List<TDepartmentFinanceModel> financeModelList = departmentFinanceRepository.findAll();


        if (!CollectionUtils.isEmpty(financeModelList)) {

            resultInfo.setAppData(financeModelList);

        } else {

            resultInfo.setAppData("");
        }
        return resultInfo;
    }
}
