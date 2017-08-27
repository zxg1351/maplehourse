package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.service.TDepartmentFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.Result;

/**
 * Created by Administrator on 2017/8/18.
 */
@Controller
@RequestMapping(value = "/tDepartmentFinance")
public class TDepartmentFinanceController {


    @Autowired
    private TDepartmentFinanceService departmentFinanceService;


    @RequestMapping(value = "selectFinance")
    public ModelAndView selectFinance() {

        ResultInfo resultInfo = departmentFinanceService.selectAllTDepartmentFinance();


        ModelAndView modelAndView = new ModelAndView("/finance");


        modelAndView.addObject("financeList", resultInfo.getAppData());

        return modelAndView;
    }
}
