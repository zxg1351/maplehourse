package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.service.MMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/8/18.
 */
@Controller
@RequestMapping(value = "/mMenu")
public class MMenuController {

    @Autowired
    private MMenuService mMenuService;


    @RequestMapping(value = "/selectMenu")
    public ModelAndView selectMenu() {


        ResultInfo resultInfo = mMenuService.selectMenu();

        ModelAndView modelAndView = new ModelAndView("/menu");
        modelAndView.addObject("menuList", resultInfo.getAppData());

        return modelAndView;
    }

}
