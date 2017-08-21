package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentSalesModel;
import com.zxg.maplehourse.repository.TDepartmentSalesRepository;
import com.zxg.maplehourse.service.TDepartmentSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TDepartmentSalesServiceImpl implements TDepartmentSalesService{

    @Autowired
    private TDepartmentSalesRepository salesRepository;

    @Override
    public ResultInfo selectAllTDepartmentSales() {

        ResultInfo resultInfo = new ResultInfo();

        List<TDepartmentSalesModel> salesModelList  = salesRepository.findAll();


        resultInfo.setAppData(salesModelList);

        return resultInfo;
    }
}
