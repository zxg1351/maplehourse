package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MBannerModel;
import com.zxg.maplehourse.repository.MBannerRepository;
import com.zxg.maplehourse.service.MBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/8/18.
 */
@Service
public class MBannerServiceImpl implements MBannerService{

    @Autowired
    private MBannerRepository mBannerRepository;


    @Override
    public ResultInfo selectAllBanner(String mBannerName) {
        ResultInfo resultInfo = new ResultInfo();

        List<MBannerModel> mBannerModelList =  mBannerRepository.findAll();

        resultInfo.setAppData(mBannerModelList);
        return resultInfo;
    }

    @Override
    public ResultInfo insertBanner(MBannerModel mBannerModel) {
        return null;
    }
}
