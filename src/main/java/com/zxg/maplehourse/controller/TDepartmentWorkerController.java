package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.service.TDepartmentWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/8/18.
 */
@Controller
@RequestMapping(value = "/tDepartmentWorker")
public class TDepartmentWorkerController {


    @Autowired
    private TDepartmentWorkerService departmentWorkerService;


    @RequestMapping(value = "/selectWorker")
    public ModelAndView selectWorker() {

        ResultInfo resultInfo = departmentWorkerService.selectAllTDepartmentWorker();
        ModelAndView modelAndView = new ModelAndView("/work");
        modelAndView.addObject("workList", resultInfo.getAppData());
        return modelAndView;
    }
}
