package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TLargeAreaModel;
import com.zxg.maplehourse.repository.TLargeAreaRepository;
import com.zxg.maplehourse.service.TLargeAreaService;
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
public class TLargeAreaServiceImpl implements TLargeAreaService {
    private static final Logger logger = LoggerFactory.getLogger(TLargeAreaServiceImpl.class);
    @Autowired
    private TLargeAreaRepository tLargeAreaRepository;

    @Override
    public ResultInfo saveLargeArea(TLargeAreaModel tLargeAreaModel) {

        tLargeAreaModel.setCreateTime(new Date());
        tLargeAreaModel.setCreateUser(1);
        TLargeAreaModel model = tLargeAreaRepository.save(tLargeAreaModel);
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setAppData(model);
        resultInfo.setResultMessage("保存成功");
        resultInfo.setResultCode("0");
        return resultInfo;
    }

    @Override
    public ResultInfo findById(Integer largeAreaId) {
        ResultInfo resultInfo = new ResultInfo();

        TLargeAreaModel model = tLargeAreaRepository.findOne(largeAreaId);
        resultInfo.setAppData(model);
        return resultInfo;
    }

    @Override
    public ResultInfo editLargeArea(TLargeAreaModel tLargeAreaModel) {
        ResultInfo resultInfo = new ResultInfo();

        int result = tLargeAreaRepository.editFinance(1, new Date(), tLargeAreaModel.getLargeAreaName(), tLargeAreaModel.getId());
        resultInfo.setAppData(result);
        resultInfo.setResultMessage("修改成功");
        resultInfo.setResultCode("success");
        return resultInfo;
    }

    @Override
    public ResultInfo deleteLargeAreaById(Integer largeAreaId) {
        ResultInfo resultInfo = new ResultInfo();
        int result = tLargeAreaRepository.deleteFinanceById(1, new Date(), "1", largeAreaId);
        resultInfo.setAppData(result);
        resultInfo.setResultMessage("删除成功");
        resultInfo.setResultCode("success");
        return resultInfo;
    }

    @Override
    public ResultInfo selectAllTLargeArea() {

        ResultInfo resultInfo = new ResultInfo();

        List<TLargeAreaModel> areaModelList = tLargeAreaRepository.findAll();
        if (!CollectionUtils.isEmpty(areaModelList)) {

            resultInfo.setAppData(areaModelList);
            logger.debug("大区域列表所示：");

        } else {

            logger.debug("暂无大区域信息数据");
        }
        return resultInfo;
    }

    @Override
    public Page<TLargeAreaModel> selectAllpageLargeArea(Pageable page) {
        Page<TLargeAreaModel> areaModelList = tLargeAreaRepository.findAll(page);
        if (!CollectionUtils.isEmpty(areaModelList.getContent())) {

            logger.debug("大区域列表所示：");

        } else {

            logger.debug("暂无大区域信息数据");
        }
        return areaModelList;
    }


}
