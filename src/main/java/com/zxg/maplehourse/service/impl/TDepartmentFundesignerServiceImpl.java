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
            logger.debug("菜单信息所示");
        }else {
            resultInfo.setAppData("");
            logger.debug("菜单信息所示");
        }
        return resultInfo;
    }
}
