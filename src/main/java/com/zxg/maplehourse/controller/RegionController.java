package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MProvinceModel;
import com.zxg.maplehourse.repository.MProvinceRepository;
import com.zxg.maplehourse.service.MRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RequestMapping(value = "/region")
public class RegionController {


    @Autowired
    private MRegionService mRegionService;

    //localhost:9091/
    @RequestMapping(value = "/selectProvice")
    public ModelAndView selectProvince() {


        ResultInfo resultInfo = mRegionService.selectProvice();

        ModelAndView modelAndView = new ModelAndView("/province");
        modelAndView.addObject("mProvince",resultInfo.getAppData());
        return modelAndView;
    }


    @RequestMapping(value = "/selectArea")
    public ModelAndView selectMarea() {

        ResultInfo resultInfo = mRegionService.selectArea();

        ModelAndView modelAndView = new ModelAndView("/area");
        modelAndView.addObject("arealist", resultInfo.getAppData());

        return modelAndView;

    }


    @RequestMapping(value = "/selectCity")
    public ModelAndView selectCity() {

        ResultInfo resultInfo = mRegionService.selectCity();

        ModelAndView modelAndView = new ModelAndView("/city");
        modelAndView.addObject("citylist", resultInfo.getAppData());

        return modelAndView;

    }



}
