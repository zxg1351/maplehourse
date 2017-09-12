package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentSalesModel;
import com.zxg.maplehourse.service.TDepartmentSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/8/18.
 * 销售
 */
@Controller
@RequestMapping(value = "/tDepartmentSales")
public class TDepartmentSalesController {


    @Autowired
    private TDepartmentSalesService tDepartmentSalesService;

    /**
     * 查询销售列表
     * @return
     */
    @RequestMapping(value = "/selecttDepartmentSales")
    public ModelAndView selecttDepartmentSales(@PageableDefault Pageable pageNo) {

//        ResultInfo resultInfo = tDepartmentSalesService.selectAllTDepartmentSales();
        Page<TDepartmentSalesModel> pageable = tDepartmentSalesService.selectPageSales(pageNo);
        ModelAndView modelAndView = new ModelAndView("/sales");
        modelAndView.addObject("totalPageNumber", pageable.getTotalElements());
        modelAndView.addObject("pageSize", pageable.getTotalPages());
        modelAndView.addObject("number", pageable.getNumber());
        modelAndView.addObject("salesList", pageable.getContent());
        return modelAndView;
    }

    @RequestMapping(value = "/newLargeArea")
    public ModelAndView newLargeArea(@Valid TLargeAreaModel largeAreaModel) {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @RequestMapping(value = "/editLargeArea")
    public ModelAndView editLargeArea(@Valid TLargeAreaModel largeAreaModel) {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
}
