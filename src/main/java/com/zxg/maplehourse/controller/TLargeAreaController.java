package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.service.TLargeAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/8/18.
 */
@Controller
@RequestMapping(value = "/tLargeArea")
public class TLargeAreaController {


    @Autowired
    private TLargeAreaService tLargeAreaService;


    @RequestMapping(value = "/selectLargeArea")
    public ModelAndView selectLargeArea() {

        ResultInfo resultInfo = tLargeAreaService.selectAllTLargeArea();

        ModelAndView modelAndView = new ModelAndView("/largeArea");
        modelAndView.addObject("areaList", resultInfo.getAppData());

        return modelAndView;


    }
}
