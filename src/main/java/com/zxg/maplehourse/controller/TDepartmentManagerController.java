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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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
     *
     * @return
     */
    @RequestMapping(value = "/selectManager")
    public ModelAndView selectManager(@PageableDefault Pageable pageNo) {

//        ResultInfo resultInfo = managerService.selectAllTDepartmentManager();
        Page<TDepartmentManagerModel> pageable = managerService.selectPageManager(pageNo);
        ModelAndView modelAndView = new ModelAndView("/manager");
        modelAndView.addObject("totalPageNumber", pageable.getTotalElements());
        modelAndView.addObject("pageSize", pageable.getTotalPages());
        modelAndView.addObject("number", pageable.getNumber());
        modelAndView.addObject("managerList", pageable.getContent());
        return modelAndView;
    }

    @RequestMapping(value = "/newManager")
    public ModelAndView newManager(@Valid TDepartmentManagerModel managerModel) {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @RequestMapping(value = "/editManager")
    public ModelAndView editManager(@Valid TDepartmentManagerModel managerModel) {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
    @RequestMapping(value = "/deleteById")
    public ModelAndView deleteDesignerById(@RequestParam Integer designerId) {
        ResultInfo resultInfo = managerService.deleteManagerById(designerId);
        ModelAndView modelAndView = new ModelAndView("redirect:/tDepartmentDesigner/selectDesigner");
        return modelAndView;
    }
    @RequestMapping(value = "/editView")
    public ModelAndView editView(@RequestParam Integer designerId) {

        ResultInfo resultInfo = managerService.findById(designerId);

        ModelAndView modelAndView = new ModelAndView("/editDesigner");
        modelAndView.addObject("designerModel", resultInfo.getAppData());
        return modelAndView;

    }

}
