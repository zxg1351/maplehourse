package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentManagerModel;
import com.zxg.maplehourse.service.TDepartmentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/8/18.
 * 项目经理
 */
@Controller
@RequestMapping(value = "/tDepartmentManager")
public class TDepartmentManagerController {

    @Autowired
    private TDepartmentManagerService managerService;

    /**
     * 查询项目经理列表
     * @return
     */
    @RequestMapping(value = "/selectManager")
    public ModelAndView selectManager(@PageableDefault Pageable pageNo) {

//        ResultInfo resultInfo = managerService.selectAllTDepartmentManager();
        Page<TDepartmentManagerModel> pageable =  managerService.selectPageManager(pageNo);
        ModelAndView modelAndView = new ModelAndView("/manager");
        modelAndView.addObject("totalPageNumber", pageable.getTotalElements());
        modelAndView.addObject("pageSize", pageable.getTotalPages());
        modelAndView.addObject("number", pageable.getNumber());
        modelAndView.addObject("managerList", pageable.getContent());
        return modelAndView;
    }

}
