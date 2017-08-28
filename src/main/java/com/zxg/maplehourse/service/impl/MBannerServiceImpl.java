package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MBannerModel;
import com.zxg.maplehourse.repository.MBannerRepository;
import com.zxg.maplehourse.service.MBannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/8/18.
 */
@Service
public class MBannerServiceImpl implements MBannerService{
    private static final Logger logger = LoggerFactory.getLogger(MBannerServiceImpl.class);
    @Autowired
    private MBannerRepository mBannerRepository;


    @Override
    public ResultInfo selectAllBanner(String mBannerName) {
        ResultInfo resultInfo = new ResultInfo();

        List<MBannerModel> mBannerModelList =  mBannerRepository.findAll();
        if (!CollectionUtils.isEmpty(mBannerModelList)){
            resultInfo.setAppData(mBannerModelList);
            logger.debug("查询轮播图成功");
        }else {
            resultInfo.setAppData("");
             logger.debug("无轮播图信息");
        }
        return resultInfo;
    }

    @Override
    public ResultInfo insertBanner(MBannerModel mBannerModel) {
        ResultInfo resultInfo = new ResultInfo();
        MBannerModel mBannerModel1 = new MBannerModel();
        mBannerModel1.setMBannerName("轮播图5");
        mBannerModel1.setMBannerUrl("http://pic.qiantucdn.com/58pic/11/24/04/67U58PIC2Db.jpg!/fw/780/watermark/url/L3dhdGVybWFyay12MS4zLnBuZw==/align/center");
        mBannerModel1.setMBannerType("0");
        mBannerModel1.setCreateTime(new Date());
        mBannerModel1.setCreateUser(1);
        MBannerModel mBannerModel2 = mBannerRepository.save(mBannerModel1);
        resultInfo.setAppData(mBannerModel2);
        logger.debug("新建轮播图成功");
        return resultInfo;
    }
}
