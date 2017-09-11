package com.zxg.maplehourse.service;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MMenuModel;
import com.zxg.maplehourse.model.TDepartmentFinanceModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Administrator on 2017/8/18.
 */
public interface TDepartmentFinanceService {


    ResultInfo selectAllTDepartmentFinance();

    Page<TDepartmentFinanceModel> selectPageFinance(Pageable pageable);


    ResultInfo saveDesigner(TDepartmentFinanceModel tDepartmentFinanceModel);

    ResultInfo findById(Integer financeId);

    ResultInfo editRole(TDepartmentFinanceModel tDepartmentDesignerModel);

    ResultInfo deleteRoleById(Integer financeId);
}
