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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
     *
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


    @RequestMapping(value = "/newFinance")
    public ModelAndView newFinance(@Valid TDepartmentFinanceModel financeModel) {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @RequestMapping(value = "/editFinance")
    public ModelAndView editFinance(@Valid TDepartmentFinanceModel financeModel) {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
    @RequestMapping(value = "/deleteById")
    public ModelAndView deleteDesignerById(@RequestParam Integer designerId) {
        ResultInfo resultInfo = departmentFinanceService.deleteRoleById(designerId);
        ModelAndView modelAndView = new ModelAndView("redirect:/tDepartmentDesigner/selectDesigner");
        return modelAndView;
    }
    @RequestMapping(value = "/editView")
    public ModelAndView editView(@RequestParam Integer designerId) {

        ResultInfo resultInfo = departmentFinanceService.findById(designerId);

        ModelAndView modelAndView = new ModelAndView("/editDesigner");
        modelAndView.addObject("designerModel", resultInfo.getAppData());
        return modelAndView;

    }




}
