package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.service.TLargeAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/8/18.
 * 大区域列表
 */
@Controller
@RequestMapping(value = "/tLargeArea")
public class TLargeAreaController {


    @Autowired
    private TLargeAreaService tLargeAreaService;

    /**
     * 查询大区域列表
     *
     * @return
     */
    @RequestMapping(value = "/selectLargeArea")
    public ModelAndView selectLargeArea() {

        ResultInfo resultInfo = tLargeAreaService.selectAllTLargeArea();

        ModelAndView modelAndView = new ModelAndView("/largeArea");
        modelAndView.addObject("largeAreaList", resultInfo.getAppData());

        return modelAndView;


    }
}
