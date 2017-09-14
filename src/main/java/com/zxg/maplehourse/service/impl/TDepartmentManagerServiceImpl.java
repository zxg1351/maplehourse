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

import java.util.Date;
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
        managerModel.setCreateTime(new Date());
        managerModel.setCreateUser(1);
        TDepartmentManagerModel model = managerRepository.save(managerModel);
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setAppData(model);
        resultInfo.setResultMessage("保存成功");
        resultInfo.setResultCode("0");
        return resultInfo;
    }

    @Override
    public ResultInfo findById(Integer managerId) {
        ResultInfo resultInfo = new ResultInfo();

        TDepartmentManagerModel model = managerRepository.findOne(managerId);
        resultInfo.setAppData(model);
        return resultInfo;
    }

    @Override
    public ResultInfo editManager(TDepartmentManagerModel managerModel) {
        ResultInfo resultInfo = new ResultInfo();

        int result = managerRepository.editManager(1, new Date(), managerModel.getName(), managerModel.getType(), managerModel.getId());
        resultInfo.setAppData(result);
        resultInfo.setResultMessage("修改成功");
        resultInfo.setResultCode("success");
        return resultInfo;
    }

    @Override
    public ResultInfo deleteManagerById(Integer managerId) {
        ResultInfo resultInfo = new ResultInfo();
        int result = managerRepository.deleteManagerById(1, new Date(), "1", managerId);
        resultInfo.setAppData(result);
        resultInfo.setResultMessage("删除成功");
        resultInfo.setResultCode("success");
        return resultInfo;
    }
}
