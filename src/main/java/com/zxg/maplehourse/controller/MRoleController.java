package com.zxg.maplehourse.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MRoleModel;
import com.zxg.maplehourse.service.MRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    /**
     * 查询角色列表
     *
     * @return
     */
    @RequestMapping(value = "/selectRole")
    public ModelAndView selectRole(@PageableDefault Pageable pageNo) {

        Page<MRoleModel> pageable = mRoleService.selectPageRole(pageNo);

        ModelAndView modelAndView = new ModelAndView("/role");
        modelAndView.addObject("totalPageNumber", pageable.getTotalElements());
        modelAndView.addObject("pageSize", pageable.getTotalPages());
        modelAndView.addObject("number", pageable.getNumber());
        modelAndView.addObject("roleList", pageable.getContent());

        return modelAndView;
    }


}
