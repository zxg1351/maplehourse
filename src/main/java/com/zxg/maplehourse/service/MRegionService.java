package com.zxg.maplehourse.service;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MAreaModel;
import com.zxg.maplehourse.model.MCityModel;
import com.zxg.maplehourse.model.MMenuModel;
import com.zxg.maplehourse.model.MProvinceModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Administrator on 2017/8/18.
 */
public interface MRegionService {


    ResultInfo selectArea();


    ResultInfo selectCity();


    ResultInfo selectProvice();

    Page<MCityModel> selectPageCity(Pageable pageable);

    Page<MProvinceModel> selectPageProvince(Pageable pageable);

    Page<MAreaModel> selectPageArea(Pageable pageable);
}
