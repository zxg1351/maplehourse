package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MRoleModel;
import com.zxg.maplehourse.repository.MRoleRepository;
import com.zxg.maplehourse.service.MRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


@Service
public class MRoleServiceImpl implements MRoleService {

    private static final Logger logger = LoggerFactory.getLogger(MRoleServiceImpl.class);

    @Autowired
    private MRoleRepository mRoleRepository;

    @Override
    public ResultInfo selectAllRole() {


        ResultInfo resultInfo = new ResultInfo();

        List<MRoleModel> mRoleModelList = mRoleRepository.findAll();

        if (!CollectionUtils.isEmpty(mRoleModelList)) {

            resultInfo.setAppData(mRoleModelList);
            logger.debug("角色列表信息显示");
        } else {

            logger.debug("暂无角色列表信息显示");
        }
        return resultInfo;
    }

    @Override
    public Page<MRoleModel> selectPageRole(Pageable pageable) {

        Page<MRoleModel> modelPage = mRoleRepository.findAll(pageable);

        return modelPage;
    }
}
