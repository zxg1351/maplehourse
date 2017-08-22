package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.service.TDepartmentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/8/18.
 */
@Controller
@RequestMapping(value = "/tDepartmentManager")
public class TDepartmentManagerController {

    @Autowired
    private TDepartmentManagerService managerService;


    @RequestMapping(value = "/selectManager")
    public ModelAndView selectManager() {

        ResultInfo resultInfo = managerService.selectAllTDepartmentManager();
        ModelAndView modelAndView = new ModelAndView("/manager");
        modelAndView.addObject("managerList", resultInfo.getAppData());
        return modelAndView;
    }

}
