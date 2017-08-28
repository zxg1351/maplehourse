package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentSuperModel;
import com.zxg.maplehourse.repository.TDepartmentSuperRepository;
import com.zxg.maplehourse.service.TDepartmentSuperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class TDepartmentSuperServiceImpl implements TDepartmentSuperService {
    private static final Logger logger = LoggerFactory.getLogger(TDepartmentSuperServiceImpl.class);
    @Autowired
    private TDepartmentSuperRepository superRepository;

    @Override
    public ResultInfo selectAllTDepartmentSuper() {

        ResultInfo resultInfo = new ResultInfo();


        List<TDepartmentSuperModel> superModelList = superRepository.findAll();

        if (!CollectionUtils.isEmpty(superModelList)) {

            resultInfo.setAppData(superModelList);
            logger.debug("菜单信息所示");

        } else {
            resultInfo.setAppData("");
            logger.debug("菜单信息所示");
        }

        return resultInfo;
    }
}
