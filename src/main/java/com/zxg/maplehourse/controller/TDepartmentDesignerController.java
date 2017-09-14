package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentDesignerModel;
import com.zxg.maplehourse.service.TDepartmentDesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.ModelAndViewResolver;

import javax.validation.Valid;
import javax.xml.transform.Result;

/**
 * Created by Administrator on 2017/8/18.
 * 设计师
 */
@Controller
@RequestMapping(value = "/tDepartmentDesigner")
public class TDepartmentDesignerController {

    @Autowired
    private TDepartmentDesignerService departmentDesignerService;

    /**
     * 查询设计师列表
     *
     * @return
     */
    @RequestMapping(value = "/selectDesigner")
    public ModelAndView selectdesigner(@PageableDefault Pageable pageNo) {

//        ResultInfo resultInfo = departmentDesignerService.selectAllTDepartmentDesigner();
        Page<TDepartmentDesignerModel> pageable = departmentDesignerService.selectPageDesigner(pageNo);
        ModelAndView modelAndView = new ModelAndView("/designer");
        modelAndView.addObject("totalPageNumber", pageable.getTotalElements());
        modelAndView.addObject("pageSize", pageable.getTotalPages());
        modelAndView.addObject("number", pageable.getNumber());
        modelAndView.addObject("designerList", pageable.getContent());

        return modelAndView;

    }

    @RequestMapping(value = "/addView")
    public ModelAndView addView() {

        ModelAndView modelAndView = new ModelAndView("/newDesigner");
        return modelAndView;
    }


    @RequestMapping(value = "/newDesigner")
    public ModelAndView newDesigner(@Valid TDepartmentDesignerModel designerModel) {

        ResultInfo resultInfo = departmentDesignerService.saveDesigner(designerModel);

        ModelAndView modelAndView = new ModelAndView("redirect:/tDepartmentDesigner/selectDesigner");
        modelAndView.addObject(resultInfo.getAppData());

        return modelAndView;
    }




    @RequestMapping(value = "/editDesigner")
    public ModelAndView editDesigner(@Valid TDepartmentDesignerModel designerModel) {
        ResultInfo resultInfo = departmentDesignerService.editDesigner(designerModel);
        ModelAndView modelAndView = new ModelAndView("redirect:/tDepartmentDesigner/selectDesigner");
        modelAndView.addObject(resultInfo.getAppData());

        return modelAndView;
    }

    @RequestMapping(value = "/deleteDesignerById")
    public ModelAndView deleteDesignerById(@RequestParam Integer designerId) {
        ResultInfo resultInfo = departmentDesignerService.deleteDesignerById(designerId);
        ModelAndView modelAndView = new ModelAndView("redirect:/tDepartmentDesigner/selectDesigner");
        return modelAndView;
    }
    @RequestMapping(value = "/editView")
    public ModelAndView editView(@RequestParam Integer designerId) {

        ResultInfo resultInfo = departmentDesignerService.findById(designerId);

        ModelAndView modelAndView = new ModelAndView("/editDesigner");
        modelAndView.addObject("designerModel", resultInfo.getAppData());
        return modelAndView;

    }


    @RequestMapping(value = "/searchList")
    public ModelAndView searchList(@Valid TDepartmentDesignerModel model ) {

        Page<TDepartmentDesignerModel> pageable = departmentDesignerService.selectDesigner(model);
        ModelAndView modelAndView = new ModelAndView("/designer");
        modelAndView.addObject("totalPageNumber", pageable.getTotalElements());
        modelAndView.addObject("pageSize", pageable.getTotalPages());
        modelAndView.addObject("number", pageable.getNumber());
        modelAndView.addObject("designerList", pageable.getContent());
        return modelAndView;
    }
}
