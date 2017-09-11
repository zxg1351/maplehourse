package com.zxg.maplehourse.service;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MMenuModel;
import com.zxg.maplehourse.model.TDepartmentDesignerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Administrator on 2017/8/18.
 */
public interface TDepartmentDesignerService {



    ResultInfo selectAllTDepartmentDesigner();

    Page<TDepartmentDesignerModel> selectPageDesigner(Pageable pageable);

    ResultInfo saveDesigner(TDepartmentDesignerModel tDepartmentDesignerModel);


    ResultInfo findById(Integer designerId);

    ResultInfo editRole(TDepartmentDesignerModel tDepartmentDesignerModel);

    ResultInfo deleteRoleById(Integer designerId);
}




