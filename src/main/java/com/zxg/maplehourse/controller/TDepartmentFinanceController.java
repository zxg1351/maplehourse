package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentFinanceModel;
import com.zxg.maplehourse.service.TDepartmentFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.Result;

/**
 * Created by Administrator on 2017/8/18.
 * 财务
 */
@Controller
@RequestMapping(value = "/tDepartmentFinance")
public class TDepartmentFinanceController {


    @Autowired
    private TDepartmentFinanceService departmentFinanceService;

    /**
     * 查询财务人员列表
     * @return
     */
    @RequestMapping(value = "/selectFinance")
    public ModelAndView selectFinance(@PageableDefault Pageable pageNo) {

//        ResultInfo resultInfo = departmentFinanceService.selectAllTDepartmentFinance();
        Page<TDepartmentFinanceModel> pageable = departmentFinanceService.selectPageFinance(pageNo);

        ModelAndView modelAndView = new ModelAndView("/finance");
        modelAndView.addObject("totalPageNumber", pageable.getTotalElements());
        modelAndView.addObject("pageSize", pageable.getTotalPages());
        modelAndView.addObject("number", pageable.getNumber());

        modelAndView.addObject("financeList", pageable.getContent());

        return modelAndView;
    }
}
