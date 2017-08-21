package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentFinanceModel;
import com.zxg.maplehourse.repository.TDepartmentFinanceRepository;
import com.zxg.maplehourse.service.TDepartmentFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TDepartmentFinanceServiceImpl implements TDepartmentFinanceService {


    @Autowired
    private TDepartmentFinanceRepository tDepartmentFinanceRepository;

    @Override
    public ResultInfo selectAllTDepartmentFinance() {
        ResultInfo resultInfo = new ResultInfo();

        List<TDepartmentFinanceModel> financeModelList = tDepartmentFinanceRepository.findAll();

        resultInfo.setAppData(resultInfo);
        return resultInfo;
    }
}
