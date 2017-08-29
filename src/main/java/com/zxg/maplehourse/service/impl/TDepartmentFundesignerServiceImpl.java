package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentFundesignerModel;
import com.zxg.maplehourse.repository.TDepartmentFundesignerRepository;
import com.zxg.maplehourse.service.TDepartmentFundesignerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class TDepartmentFundesignerServiceImpl implements TDepartmentFundesignerService {

    private static final Logger logger = LoggerFactory.getLogger(TDepartmentFundesignerServiceImpl.class);
    @Autowired
    private TDepartmentFundesignerRepository fundesignerRepository;

    @Override
    public ResultInfo selectAllTDepartmentFundesigner() {

        ResultInfo resultInfo = new ResultInfo();

        List<TDepartmentFundesignerModel> fundesignerModelList = fundesignerRepository.findAll();

        if (!CollectionUtils.isEmpty(fundesignerModelList)){


            resultInfo.setAppData(fundesignerModelList);
            logger.debug("家具设计师列表信息显示");
        }else {
            resultInfo.setAppData("");
            logger.debug("暂无家具设计师列表显示");
        }
        return resultInfo;
    }
}
