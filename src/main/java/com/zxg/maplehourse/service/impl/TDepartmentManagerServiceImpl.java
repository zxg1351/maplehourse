package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentManagerModel;
import com.zxg.maplehourse.repository.TDepartmentManagerRepository;
import com.zxg.maplehourse.service.TDepartmentManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
            logger.debug("项目经理列表信息显示");
        } else {

            logger.debug("暂无项目经理列表信息");
        }

        return resultInfo;
    }

    @Override
    public Page<TDepartmentManagerModel> selectPageManager(Pageable pageable) {


        Page<TDepartmentManagerModel> tDepartmentManagerModelPage = managerRepository.findAll(pageable);
        return tDepartmentManagerModelPage;
    }

    @Override
    public ResultInfo saveManager(TDepartmentManagerModel managerModel) {
        return null;
    }

    @Override
    public ResultInfo findById(Integer managerId) {
        return null;
    }

    @Override
    public ResultInfo editManager(TDepartmentManagerModel managerModel) {
        return null;
    }

    @Override
    public ResultInfo deleteManagerById(Integer managerId) {
        return null;
    }
}
