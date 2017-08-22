package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentSalesModel;
import com.zxg.maplehourse.repository.TDepartmentSalesRepository;
import com.zxg.maplehourse.service.TDepartmentSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class TDepartmentSalesServiceImpl implements TDepartmentSalesService {


    @Autowired
    private TDepartmentSalesRepository salesRepository;

    @Override
    public ResultInfo selectAllTDepartmentSales() {


        ResultInfo resultInfo = new ResultInfo();
        List<TDepartmentSalesModel> salesModelList = salesRepository.findAll();

        if (!CollectionUtils.isEmpty(salesModelList)) {

            resultInfo.setAppData(salesModelList);
        } else {

            resultInfo.setAppData("");
        }
        return resultInfo;
    }
}
