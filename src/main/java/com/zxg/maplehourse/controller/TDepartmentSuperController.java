package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentSuperModel;
import com.zxg.maplehourse.service.TDepartmentSuperService;
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
 * 项目监理
 */
@Controller
@RequestMapping(value = "/tDepartmentSuper")
public class TDepartmentSuperController {

    @Autowired
    private TDepartmentSuperService tDepartmentSuperService;

    /**
     * 查询项目监理列表
     *
     * @return
     */
    @RequestMapping(value = "/selectSuper")
    public ModelAndView selectSuper(@PageableDefault Pageable pageNo) {

//        ResultInfo resultInfo = tDepartmentSuperService.selectAllTDepartmentSuper();

        Page<TDepartmentSuperModel> pageable = tDepartmentSuperService.selectPageSuper(pageNo);
        ModelAndView modelAndView = new ModelAndView("/super");
        modelAndView.addObject("totalPageNumber", pageable.getTotalElements());
        modelAndView.addObject("pageSize", pageable.getTotalPages());
        modelAndView.addObject("number", pageable.getNumber());
        modelAndView.addObject("superList", pageable.getContent());
        return modelAndView;
    }

    @RequestMapping(value = "/newSuper")
    public ModelAndView newSuper(@Valid TDepartmentSuperModel superModel) {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @RequestMapping(value = "/editSuper")
    public ModelAndView editSuper(@Valid TDepartmentSuperModel superModel) {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
    @RequestMapping(value = "/deleteById")
    public ModelAndView deleteDesignerById(@RequestParam Integer designerId) {
        ResultInfo resultInfo = tDepartmentSuperService.deleteSuperById(designerId);
        ModelAndView modelAndView = new ModelAndView("redirect:/tDepartmentDesigner/selectDesigner");
        return modelAndView;
    }
    @RequestMapping(value = "/editView")
    public ModelAndView editView(@RequestParam Integer designerId) {

        ResultInfo resultInfo = tDepartmentSuperService.findById(designerId);

        ModelAndView modelAndView = new ModelAndView("/editDesigner");
        modelAndView.addObject("designerModel", resultInfo.getAppData());
        return modelAndView;

    }


}
