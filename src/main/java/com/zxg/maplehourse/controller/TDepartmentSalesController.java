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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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
     *
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

    @RequestMapping(value = "/newSales")
    public ModelAndView newSales(@Valid TDepartmentSalesModel salesModel) {
        ResultInfo resultInfo = tDepartmentSalesService.saveSales(salesModel);

        ModelAndView modelAndView = new ModelAndView("redirect:/tDepartmentSales/selecttDepartmentSales");
        modelAndView.addObject(resultInfo.getAppData());
        return modelAndView;
    }

    @RequestMapping(value = "/editSales")
    public ModelAndView editSales(@Valid TDepartmentSalesModel salesModel) {
        ResultInfo resultInfo = tDepartmentSalesService.editSales(salesModel);

        ModelAndView modelAndView = new ModelAndView("redirect:/tDepartmentSales/selecttDepartmentSales");
        modelAndView.addObject(resultInfo.getAppData());
        return modelAndView;
    }

    @RequestMapping(value = "/deleteById")
    public ModelAndView deleteDesignerById(@RequestParam Integer id) {
        ResultInfo resultInfo = tDepartmentSalesService.deleteSalesById(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/tDepartmentSales/selecttDepartmentSales");
        return modelAndView;
    }

    @RequestMapping(value = "/editView")
    public ModelAndView editView(@RequestParam Integer id) {

        ResultInfo resultInfo = tDepartmentSalesService.findById(id);

        ModelAndView modelAndView = new ModelAndView("/editSales");
        modelAndView.addObject("salesModel", resultInfo.getAppData());
        return modelAndView;

    }

}
