package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MAreaModel;
import com.zxg.maplehourse.model.MCityModel;
import com.zxg.maplehourse.model.MProvinceModel;
import com.zxg.maplehourse.repository.MAreaRepository;
import com.zxg.maplehourse.repository.MCityRepository;
import com.zxg.maplehourse.repository.MProvinceRepository;
import com.zxg.maplehourse.service.MRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


@Service
public class MRegionServiceImpl implements MRegionService {
    @Autowired
    private MAreaRepository mAreaRepository;

    @Autowired
    private MCityRepository mCityRepository;

    @Autowired
    private MProvinceRepository mProvinceRepository;


    @Override
    public ResultInfo selectArea() {
        ResultInfo resultInfo = new ResultInfo();

        List<MAreaModel> mAreaModelList = mAreaRepository.findAll();

        resultInfo.setAppData(mAreaModelList);


        return resultInfo;
    }

    @Override
    public ResultInfo selectCity() {

        ResultInfo resultInfo = new ResultInfo();

        List<MCityModel> mCityModelList = mCityRepository.findAll();
        if (!CollectionUtils.isEmpty(mCityModelList)) {
            resultInfo.setAppData(mCityModelList);
        }
        return resultInfo;
    }

    @Override
    public ResultInfo selectProvice() {

        ResultInfo resultInfo = new ResultInfo();
        List<MProvinceModel> mProvinceModelList = mProvinceRepository.findAllBy();
        if (!CollectionUtils.isEmpty(mProvinceModelList)) {

            resultInfo.setAppData(mProvinceModelList);
        }
        return resultInfo;
    }
}
