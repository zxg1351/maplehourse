package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.service.TDepartmentSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/8/18.
 */
@Controller
@RequestMapping(value = "/tDepartmentSales")
public class TDepartmentSalesController {


    @Autowired
    private TDepartmentSalesService tDepartmentSalesService;


    @RequestMapping(value = "/selecttDepartmentSales")
    public ModelAndView selecttDepartmentSales() {

        ResultInfo resultInfo = tDepartmentSalesService.selectAllTDepartmentSales();

        ModelAndView modelAndView = new ModelAndView("/sales");
        modelAndView.addObject("salesList", resultInfo.getAppData());
        return modelAndView;
    }


}
