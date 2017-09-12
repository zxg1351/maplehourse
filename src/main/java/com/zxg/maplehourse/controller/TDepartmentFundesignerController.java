package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentFundesignerModel;
import com.zxg.maplehourse.repository.TDepartmentFundesignerRepository;
import com.zxg.maplehourse.service.TDepartmentFundesignerService;
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
 * 家具设计师
 */
@Controller
@RequestMapping(value = "/tDepartmentFundesigner")
public class TDepartmentFundesignerController {
    @Autowired
    private TDepartmentFundesignerService fundesignerService;

    /**
     * 查询家具设计师列表
     *
     * @return
     */
    @RequestMapping(value = "/selectfundesigner")
    public ModelAndView selectfundesigner(@PageableDefault Pageable pageNo) {

//        ResultInfo resultInfo = fundesignerService.selectAllTDepartmentFundesigner();


        Page<TDepartmentFundesignerModel> pageable = fundesignerService.selectPageFundesigner(pageNo);
        ModelAndView modelAndView = new ModelAndView("/fundesigner");
        modelAndView.addObject("totalPageNumber", pageable.getTotalElements());
        modelAndView.addObject("pageSize", pageable.getTotalPages());
        modelAndView.addObject("number", pageable.getNumber());
        modelAndView.addObject("fundesignerList", pageable.getContent());

        return modelAndView;
    }

    @RequestMapping(value = "/newFundesigner")
    public ModelAndView newFundesigner(@Valid TDepartmentFundesignerModel fundesignerModel) {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @RequestMapping(value = "/editFundesigner")
    public ModelAndView editFundesigner(@Valid TDepartmentFundesignerModel fundesignerModel) {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }


    @RequestMapping(value = "/deleteById")
    public ModelAndView deleteDesignerById(@RequestParam Integer designerId) {
        ResultInfo resultInfo = fundesignerService.deleteFundesignerById(designerId);
        ModelAndView modelAndView = new ModelAndView("redirect:/tDepartmentDesigner/selectDesigner");
        return modelAndView;
    }

    @RequestMapping(value = "/editView")
    public ModelAndView editView(@RequestParam Integer designerId) {

        ResultInfo resultInfo = fundesignerService.findById(designerId);

        ModelAndView modelAndView = new ModelAndView("/editDesigner");
        modelAndView.addObject("designerModel", resultInfo.getAppData());
        return modelAndView;

    }

}

