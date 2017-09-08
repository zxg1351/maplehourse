package com.zxg.maplehourse.service;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MBannerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Administrator on 2017/8/18.
 */

public interface MBannerService {

    //http://img2.3lian.com/2014/f6/173/d/51.jpg
    //http://www.hanhande.com/upload/151230/1283568_105451_1.jpg
   // http://pic.qiantucdn.com/58pic/27/06/74/12C58PICR2b_1024.jpg!/fw/780/watermark/url/L3dhdGVybWFyay12MS4zLnBuZw==/align/center
    //http://pic.qiantucdn.com/58pic/14/10/35/36N58PICq9g_1024.jpg!/fw/780/watermark/url/L3dhdGVybWFyay12MS4zLnBuZw==/align/center
    //查询所有(根据名字进行查询)
     ResultInfo selectAllBanner(String mBannerName);


     ResultInfo insertBanner(MBannerModel mBannerModel);


     Page<MBannerModel> selectPageBanner(Pageable pageable);


     ResultInfo findById(Integer mbannerId);


     ResultInfo editBanner(MBannerModel mBannerModel);


     ResultInfo deleteById(Integer mbannerId);

     Page<MBannerModel> selectBanner(MBannerModel mRoleModel);
}
