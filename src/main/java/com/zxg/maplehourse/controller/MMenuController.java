package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MMenuModel;
import com.zxg.maplehourse.service.MMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/8/18.
 * 查询菜单
 */
@Controller
@RequestMapping(value = "/mMenu")
public class MMenuController {

    @Autowired
    private MMenuService mMenuService;

    /**
     * 查询菜单列表
     * @return
     */
    @RequestMapping(value = "/selectMenu")
    public ModelAndView selectMenu(@PageableDefault Pageable pageNo) {


//        ResultInfo resultInfo = mMenuService.selectMenu();
        Page<MMenuModel> pageable = mMenuService.selectPageMenu(pageNo);
        ModelAndView modelAndView = new ModelAndView("/menu");
        modelAndView.addObject("totalPageNumber", pageable.getTotalElements());
        modelAndView.addObject("pageSize", pageable.getTotalPages());
        modelAndView.addObject("number", pageable.getNumber());
        modelAndView.addObject("menuList", pageable.getContent());

        return modelAndView;
    }

}
