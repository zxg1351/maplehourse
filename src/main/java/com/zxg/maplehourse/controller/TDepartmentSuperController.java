package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.service.TDepartmentSuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/8/18.
 */
@Controller
@RequestMapping(value = "/tDepartmentSuper")
public class TDepartmentSuperController {

    @Autowired
    private TDepartmentSuperService tDepartmentSuperService;


    @RequestMapping(value = "/selectSuper")
    public ModelAndView selectSuper() {

        ResultInfo resultInfo = tDepartmentSuperService.selectAllTDepartmentSuper();
        ModelAndView modelAndView = new ModelAndView("/super");
        modelAndView.addObject("superList", resultInfo.getAppData());
        return modelAndView;
    }


}
