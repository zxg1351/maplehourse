package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentSalesModel;
import com.zxg.maplehourse.repository.TDepartmentSalesRepository;
import com.zxg.maplehourse.service.TDepartmentSalesService;
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
public class TDepartmentSalesServiceImpl implements TDepartmentSalesService {

    private static final Logger logger = LoggerFactory.getLogger(TDepartmentSalesServiceImpl.class);
    @Autowired
    private TDepartmentSalesRepository salesRepository;

    @Override
    public ResultInfo saveSales(TDepartmentSalesModel salesModel) {
        TDepartmentSalesModel model = salesRepository.save(salesModel);
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setAppData(model);
        resultInfo.setResultMessage("保存成功");
        resultInfo.setResultCode("0");
        return resultInfo;
    }

    @Override
    public ResultInfo findById(Integer salesId) {
        ResultInfo resultInfo = new ResultInfo();

        TDepartmentSalesModel model = salesRepository.findOne(salesId);
        resultInfo.setAppData(model);
        return resultInfo;
    }

    @Override
    public ResultInfo editSales(TDepartmentSalesModel salesModel) {
        ResultInfo resultInfo = new ResultInfo();

        int result = salesRepository.editSales(1, new Date(), salesModel.getSaleName(), salesModel.getSaleType(), salesModel.getId());
        resultInfo.setAppData(result);
        resultInfo.setResultMessage("修改成功");
        resultInfo.setResultCode("success");
        return resultInfo;
    }

    @Override
    public ResultInfo deleteSalesById(Integer salesId) {
        ResultInfo resultInfo = new ResultInfo();
        int result = salesRepository.deleteSalesById(1, new Date(), "1", salesId);
        resultInfo.setAppData(result);
        resultInfo.setResultMessage("删除成功");
        resultInfo.setResultCode("success");
        return resultInfo;
    }

    @Override
    public ResultInfo selectAllTDepartmentSales() {


        ResultInfo resultInfo = new ResultInfo();
        List<TDepartmentSalesModel> salesModelList = salesRepository.findAll();

        if (!CollectionUtils.isEmpty(salesModelList)) {

            resultInfo.setAppData(salesModelList);
            logger.debug("销售列表信息显示");
        } else {

            logger.debug("暂无销售列表信息");
        }
        return resultInfo;
    }

    @Override
    public Page<TDepartmentSalesModel> selectPageSales(Pageable pageable) {

        Page<TDepartmentSalesModel> page = salesRepository.findAll(pageable);

        return page;
    }
}
