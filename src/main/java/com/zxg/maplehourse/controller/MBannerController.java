package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MBannerModel;
import com.zxg.maplehourse.service.MBannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/8/18.
 * 轮播图列表
 */
@Controller
@RequestMapping(value = "/mBanner")
public class MBannerController
{


    @Autowired
    private MBannerService mBannerService;

    @RequestMapping(value = "/selectBanner")
    public ModelAndView selectBanner(HttpServletRequest request){
        String  name = "";

        ResultInfo resultInfo = mBannerService.selectAllBanner(name);

        ModelAndView modelAndView = new ModelAndView("/banner");
        modelAndView.addObject("mbannerList",resultInfo.getAppData());
        return  modelAndView;
    }


    @RequestMapping(value = "/insertBanner")
    public ResultInfo insertBanner(){

        MBannerModel mBannerModel = new MBannerModel();
        ResultInfo resultInfo = mBannerService.insertBanner(mBannerModel);

        return resultInfo;
    }
}
