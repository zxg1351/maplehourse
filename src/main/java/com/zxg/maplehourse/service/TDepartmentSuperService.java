package com.zxg.maplehourse.service;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MMenuModel;
import com.zxg.maplehourse.model.TDepartmentSuperModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Administrator on 2017/8/18.
 */
public interface TDepartmentSuperService {

    ResultInfo selectAllTDepartmentSuper();

    Page<TDepartmentSuperModel> selectPageSuper(Pageable pageable);


    ResultInfo saveSuper(TDepartmentSuperModel superModel);

    ResultInfo findById(Integer superId);

    ResultInfo editSuper(TDepartmentSuperModel superModel);

    ResultInfo deleteSuperById(Integer superId);

    Page<TDepartmentSuperModel> selectSuper(TDepartmentSuperModel model);
}
