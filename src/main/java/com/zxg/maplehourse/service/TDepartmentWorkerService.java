package com.zxg.maplehourse.service;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MMenuModel;
import com.zxg.maplehourse.model.TDepartmentWorkerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Administrator on 2017/8/18.
 */
public interface TDepartmentWorkerService {

    ResultInfo selectAllTDepartmentWorker();

    Page<TDepartmentWorkerModel> selectPageWorker(Pageable pageable);

    ResultInfo saveWork(TDepartmentWorkerModel workerModel);

    ResultInfo findById(Integer workId);

    ResultInfo editWork(TDepartmentWorkerModel workerModel);

    ResultInfo deleteWorkById(Integer workId);

    Page<TDepartmentWorkerModel> selectWorker(TDepartmentWorkerModel model);
}
