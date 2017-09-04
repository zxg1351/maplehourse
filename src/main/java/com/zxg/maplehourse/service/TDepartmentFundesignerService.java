package com.zxg.maplehourse.service;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MMenuModel;
import com.zxg.maplehourse.model.TDepartmentFundesignerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Administrator on 2017/8/18.
 */
public interface TDepartmentFundesignerService {


    ResultInfo selectAllTDepartmentFundesigner();
    Page<TDepartmentFundesignerModel> selectPageFundesigner(Pageable pageable);
}
