package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TLargeAreaModel;
import com.zxg.maplehourse.repository.TLargeAreaRepository;
import com.zxg.maplehourse.service.TLargeAreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class TLargeAreaServiceImpl implements TLargeAreaService {
    private static final Logger logger = LoggerFactory.getLogger(TLargeAreaServiceImpl.class);
    @Autowired
    private TLargeAreaRepository tLargeAreaRepository;

    @Override
    public ResultInfo selectAllTLargeArea() {

        ResultInfo resultInfo = new ResultInfo();

        List<TLargeAreaModel> areaModelList = tLargeAreaRepository.findAll();
        if (!CollectionUtils.isEmpty(areaModelList)) {

            resultInfo.setAppData(areaModelList);
            logger.debug("大区域列表所示：");

        } else {

            resultInfo.setAppData("");
            logger.debug("暂无大区域信息数据");
        }
        return resultInfo;
    }
}
