package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MMenuModel;
import com.zxg.maplehourse.repository.MMenuRepository;
import com.zxg.maplehourse.service.MMenuService;
import com.zxg.maplehourse.service.MUserMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MMenuServiceImpl implements MMenuService {

    @Autowired
    private MMenuRepository mMenuRepository;

    @Override
    public ResultInfo selectMenu() {
        ResultInfo resultInfo = new ResultInfo();

        List<MMenuModel> mMenuModelList = mMenuRepository.findAll();

        resultInfo.setAppData(mMenuModelList);
        return resultInfo;
    }
}
