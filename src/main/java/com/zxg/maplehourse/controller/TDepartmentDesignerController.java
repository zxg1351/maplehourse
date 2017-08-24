package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.service.TDepartmentDesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.ModelAndViewResolver;

import javax.xml.transform.Result;

/**
 * Created by Administrator on 2017/8/18.
 */
@Controller
@RequestMapping(value = "/tDepartmentDesigner")
public class TDepartmentDesignerController {

    @Autowired
    private TDepartmentDesignerService departmentDesignerService;

    @RequestMapping(value = "/selectDesigner")
    public ModelAndView selectdesigner() {

        ResultInfo resultInfo = departmentDesignerService.selectAllTDepartmentDesigner();


        ModelAndView modelAndView = new ModelAndView("/  ");

        modelAndView.addObject("designerList", resultInfo.getAppData());

        return modelAndView;

    }


}
