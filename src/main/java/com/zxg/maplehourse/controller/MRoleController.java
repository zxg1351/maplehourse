package com.zxg.maplehourse.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.service.MRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/8/18.
 * 角色列表
 */
@Controller
@RequestMapping(value = "/mRole")
public class MRoleController {

    @Autowired
    private MRoleService mRoleService;


    @RequestMapping(value = "/selectRole")
    public ModelAndView selectRole() {

        ResultInfo resultInfo = mRoleService.selectAllRole();

        ModelAndView modelAndView = new ModelAndView("/role");

        modelAndView.addObject("roleList", resultInfo.getAppData());
        return modelAndView;
    }


}
