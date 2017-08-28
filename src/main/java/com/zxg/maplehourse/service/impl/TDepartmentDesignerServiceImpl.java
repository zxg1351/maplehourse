package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentDesignerModel;
import com.zxg.maplehourse.repository.TDepartmentDesignerRepository;
import com.zxg.maplehourse.service.TDepartmentDesignerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


@Service
public class TDepartmentDesignerServiceImpl implements TDepartmentDesignerService {

    private static final Logger logger = LoggerFactory.getLogger(TDepartmentDesignerServiceImpl.class);

    @Autowired
    private TDepartmentDesignerRepository tDepartmentDesignerRepository;

    @Override
    public ResultInfo selectAllTDepartmentDesigner() {

        ResultInfo resultInfo = new ResultInfo();

        List<TDepartmentDesignerModel> departmentDesignerModelList = tDepartmentDesignerRepository.findAll();


        if (!CollectionUtils.isEmpty(departmentDesignerModelList)) {

            resultInfo.setAppData(departmentDesignerModelList);
            logger.debug("菜单信息所示");
        } else {

            resultInfo.setAppData("");
            logger.debug("菜单信息所示");
        }
        return resultInfo;
    }
}
