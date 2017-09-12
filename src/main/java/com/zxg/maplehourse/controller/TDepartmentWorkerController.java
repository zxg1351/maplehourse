package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TDepartmentWorkerModel;
import com.zxg.maplehourse.service.TDepartmentWorkerService;
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
 * 工人列表
 */
@Controller
@RequestMapping(value = "/tDepartmentWorker")
public class TDepartmentWorkerController {


    @Autowired
    private TDepartmentWorkerService departmentWorkerService;

    /**
     * 查询工人列表
     *
     * @return
     */
    @RequestMapping(value = "/selectWorker")
    public ModelAndView selectWorker(@PageableDefault Pageable pageNo) {

//        ResultInfo resultInfo = departmentWorkerService.selectAllTDepartmentWorker();
        Page<TDepartmentWorkerModel> pageable = departmentWorkerService.selectPageWorker(pageNo);

        ModelAndView modelAndView = new ModelAndView("/work");
        modelAndView.addObject("totalPageNumber", pageable.getTotalElements());
        modelAndView.addObject("pageSize", pageable.getTotalPages());
        modelAndView.addObject("number", pageable.getNumber());
        modelAndView.addObject("workList", pageable.getContent());
        return modelAndView;
    }

    @RequestMapping(value = "/newWorker")
    public ModelAndView newWorker(@Valid TDepartmentWorkerModel workerModel) {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @RequestMapping(value = "/editWorker")
    public ModelAndView editWorker(@Valid TDepartmentWorkerModel workerModel) {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @RequestMapping(value = "/deleteById")
    public ModelAndView deleteDesignerById(@RequestParam Integer designerId) {
        ResultInfo resultInfo = departmentWorkerService.deleteWorkById(designerId);
        ModelAndView modelAndView = new ModelAndView("redirect:/tDepartmentDesigner/selectDesigner");
        return modelAndView;
    }

    @RequestMapping(value = "/editView")
    public ModelAndView editView(@RequestParam Integer designerId) {

        ResultInfo resultInfo = departmentWorkerService.findById(designerId);

        ModelAndView modelAndView = new ModelAndView("/editDesigner");
        modelAndView.addObject("designerModel", resultInfo.getAppData());
        return modelAndView;

    }

}
