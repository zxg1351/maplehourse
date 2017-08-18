package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.service.MBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/8/18.
 */
@Controller
@RequestMapping(value = "/mBanner")
public class MBannerController
{

    @Autowired
    private MBannerService mBannerService;

    @RequestMapping(value = "/selectBanner")
    public ResultInfo selectBanner(HttpServletRequest request){
        String  name = "";

        ResultInfo resultInfo = mBannerService.selectAllBanner(name);
        return  resultInfo;
    }
}
