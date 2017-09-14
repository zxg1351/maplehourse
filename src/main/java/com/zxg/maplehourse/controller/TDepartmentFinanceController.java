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

    @RequestMapping(value = "/addView")
    public ModelAndView addView() {

        ModelAndView modelAndView = new ModelAndView("/newFinance");
        return modelAndView;
    }

    @RequestMapping(value = "/newFinance")
    public ModelAndView newFinance(@Valid TDepartmentFinanceModel financeModel) {
        ResultInfo resultInfo = departmentFinanceService.saveDesigner(financeModel);

        ModelAndView modelAndView = new ModelAndView("redirect:/tDepartmentFinance/selectFinance");
        modelAndView.addObject(resultInfo.getAppData());
        return modelAndView;
    }

    @RequestMapping(value = "/editFinance")
    public ModelAndView editFinance(@Valid TDepartmentFinanceModel financeModel) {
        ResultInfo resultInfo = departmentFinanceService.editFinance(financeModel);

        ModelAndView modelAndView = new ModelAndView("redirect:/tDepartmentFinance/selectFinance");
        modelAndView.addObject(resultInfo.getAppData());
        return modelAndView;
    }

    @RequestMapping(value = "/deleteById")
    public ModelAndView deleteDesignerById(@RequestParam Integer id) {
        ResultInfo resultInfo = departmentFinanceService.deleteRoleById(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/tDepartmentFinance/selectFinance");
        return modelAndView;
    }

    @RequestMapping(value = "/editView")
    public ModelAndView editView(@RequestParam Integer id) {

        ResultInfo resultInfo = departmentFinanceService.findById(id);

        ModelAndView modelAndView = new ModelAndView("/editFinance");
        modelAndView.addObject("financeModel", resultInfo.getAppData());
        return modelAndView;

    }


}
