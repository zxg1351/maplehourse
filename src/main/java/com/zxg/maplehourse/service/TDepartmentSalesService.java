package com.zxg.maplehourse.service;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MMenuModel;
import com.zxg.maplehourse.model.TDepartmentSalesModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Administrator on 2017/8/18.
 */
public interface TDepartmentSalesService {


    ResultInfo selectAllTDepartmentSales();

    Page<TDepartmentSalesModel> selectPageSales(Pageable pageable);

    ResultInfo saveSales(TDepartmentSalesModel salesModel);

    ResultInfo findById(Integer salesId);

    ResultInfo editSales(TDepartmentSalesModel salesModel);

    ResultInfo deleteSalesById(Integer salesId);
    Page<TDepartmentSalesModel> selectSales(TDepartmentSalesModel model);
}
