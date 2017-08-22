package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.repository.TDepartmentFundesignerRepository;
import com.zxg.maplehourse.service.TDepartmentFundesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.Result;

/**
 * Created by Administrator on 2017/8/18.
 */
@Controller
@RequestMapping(value = "/tDepartmentFundesigner")
public class TDepartmentFundesignerController {
    @Autowired
    private TDepartmentFundesignerService fundesignerService;


    @RequestMapping(value = "/selectfundesigner")
    public ModelAndView selectfundesigner() {

        ResultInfo resultInfo = fundesignerService.selectAllTDepartmentFundesigner();
        ModelAndView modelAndView = new ModelAndView("/fundesigner");
        modelAndView.addObject("fundesignerList", resultInfo.getAppData());

        return modelAndView;
    }

}
