package com.zxg.maplehourse.service;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MMenuModel;
import com.zxg.maplehourse.model.TDepartmentManagerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Administrator on 2017/8/18.
 */
public interface TDepartmentManagerService {


    ResultInfo selectAllTDepartmentManager();


    Page<TDepartmentManagerModel> selectPageManager(Pageable pageable);

    ResultInfo saveManager(TDepartmentManagerModel managerModel);

    ResultInfo findById(Integer managerId);

    ResultInfo editManager(TDepartmentManagerModel managerModel);

    ResultInfo deleteManagerById(Integer managerId);
}
