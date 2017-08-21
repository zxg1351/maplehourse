package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TLargeAreaModel;
import com.zxg.maplehourse.repository.TLargeAreaRepository;
import com.zxg.maplehourse.service.TLargeAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TLargeAreaServiceImpl implements TLargeAreaService {


    @Autowired
    private TLargeAreaRepository tLargeAreaRepository;

    @Override
    public ResultInfo selectAllTLargeArea() {
        ResultInfo resultInfo = new ResultInfo();

        List<TLargeAreaModel> largeAreaModelList = tLargeAreaRepository.findAll();

        resultInfo.setAppData(largeAreaModelList);
        return resultInfo;
    }


}
