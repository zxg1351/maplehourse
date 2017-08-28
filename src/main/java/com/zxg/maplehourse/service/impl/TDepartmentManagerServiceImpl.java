package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentManagerModel;
import com.zxg.maplehourse.repository.TDepartmentManagerRepository;
import com.zxg.maplehourse.service.TDepartmentManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class TDepartmentManagerServiceImpl implements TDepartmentManagerService {

    private static final Logger logger = LoggerFactory.getLogger(TDepartmentManagerServiceImpl.class);
    @Autowired
    private TDepartmentManagerRepository managerRepository;


    @Override
    public ResultInfo selectAllTDepartmentManager() {

        ResultInfo resultInfo = new ResultInfo();

        List<TDepartmentManagerModel> managerModelList = managerRepository.findAll();

        if (!CollectionUtils.isEmpty(managerModelList)) {


            resultInfo.setAppData(managerModelList);
            logger.debug("菜单信息所示");
        } else {

            resultInfo.setAppData("");
            logger.debug("菜单信息所示");
        }

        return resultInfo;
    }
}
