package com.zxg.maplehourse.service;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TLargeAreaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Administrator on 2017/8/18.
 */
public interface TLargeAreaService {
    ResultInfo selectAllTLargeArea();


    Page<TLargeAreaModel> selectAllpageLargeArea(Pageable page);
}
