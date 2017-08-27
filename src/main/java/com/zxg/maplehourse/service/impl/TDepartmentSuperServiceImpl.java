package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentSuperModel;
import com.zxg.maplehourse.repository.TDepartmentSuperRepository;
import com.zxg.maplehourse.service.TDepartmentSuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class TDepartmentSuperServiceImpl implements TDepartmentSuperService {

    @Autowired
    private TDepartmentSuperRepository superRepository;

    @Override
    public ResultInfo selectAllTDepartmentSuper() {

        ResultInfo resultInfo = new ResultInfo();


        List<TDepartmentSuperModel> superModelList = superRepository.findAll();

        if (!CollectionUtils.isEmpty(superModelList)) {

            resultInfo.setAppData(superModelList);

        } else {
            resultInfo.setAppData("");
        }

        return resultInfo;
    }
}
