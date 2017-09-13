package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentSuperModel;
import com.zxg.maplehourse.repository.TDepartmentSuperRepository;
import com.zxg.maplehourse.service.TDepartmentSuperService;
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
public class TDepartmentSuperServiceImpl implements TDepartmentSuperService {
    private static final Logger logger = LoggerFactory.getLogger(TDepartmentSuperServiceImpl.class);
    @Autowired
    private TDepartmentSuperRepository superRepository;

    @Override
    public ResultInfo saveSuper(TDepartmentSuperModel superModel) {
        TDepartmentSuperModel model = superRepository.save(superModel);
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setAppData(model);
        resultInfo.setResultMessage("保存成功");
        resultInfo.setResultCode("0");
        return resultInfo;
    }

    @Override
    public ResultInfo findById(Integer superId) {
        ResultInfo resultInfo = new ResultInfo();

        TDepartmentSuperModel model = superRepository.findOne(superId);
        resultInfo.setAppData(model);
        return resultInfo;
    }

    @Override
    public ResultInfo editSuper(TDepartmentSuperModel superModel) {
        ResultInfo resultInfo = new ResultInfo();

        int result = superRepository.editFinance(1, new Date(), superModel.getName(), superModel.getType(), superModel.getId());
        resultInfo.setAppData(result);
        resultInfo.setResultMessage("修改成功");
        resultInfo.setResultCode("success");
        return resultInfo;
    }

    @Override
    public ResultInfo deleteSuperById(Integer superId) {
        ResultInfo resultInfo = new ResultInfo();
        int result = superRepository.deleteFinanceById(1, new Date(), "1", superId);
        resultInfo.setAppData(result);
        resultInfo.setResultMessage("删除成功");
        resultInfo.setResultCode("success");
        return resultInfo;
    }

    @Override
    public ResultInfo selectAllTDepartmentSuper() {

        ResultInfo resultInfo = new ResultInfo();


        List<TDepartmentSuperModel> superModelList = superRepository.findAll();

        if (!CollectionUtils.isEmpty(superModelList)) {

            resultInfo.setAppData(superModelList);
            logger.debug("项目监理列表信息显示");

        } else {
            logger.debug("暂无监理列表信息显示");
        }

        return resultInfo;
    }

    @Override
    public Page<TDepartmentSuperModel> selectPageSuper(Pageable pageable) {

        Page<TDepartmentSuperModel> superModels = superRepository.findAll(pageable);
        return superModels;
    }
}
