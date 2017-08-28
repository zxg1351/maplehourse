package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MUserModel;
import com.zxg.maplehourse.repository.MUserRepository;
import com.zxg.maplehourse.service.MUserService;
import org.hibernate.action.internal.CollectionRecreateAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class MUserServiceImpl implements MUserService {

    private static final Logger logger = LoggerFactory.getLogger(MUserServiceImpl.class);
    @Autowired
    private MUserRepository mUserRepository;

    @Override
    public ResultInfo selectAllUser() {

        ResultInfo resultInfo = new ResultInfo();

        List<MUserModel> mUserModelList = mUserRepository.findAll();


        if (!CollectionUtils.isEmpty(mUserModelList)) {

            resultInfo.setAppData(mUserModelList);
            logger.debug("菜单信息所示");
        } else {
            resultInfo.setAppData("");
            logger.debug("菜单信息所示");
        }
        return resultInfo;
    }
}
