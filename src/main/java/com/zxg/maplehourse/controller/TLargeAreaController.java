package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.TLargeAreaModel;
import com.zxg.maplehourse.service.TLargeAreaService;
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
 * 大区域列表
 */
@Controller
@RequestMapping(value = "/tLargeArea")
public class TLargeAreaController {


    @Autowired
    private TLargeAreaService tLargeAreaService;

    /**
     * 查询大区域列表
     *
     * @return
     */
    @RequestMapping(value = "/selectLargeArea")
    public ModelAndView selectLargeArea(@PageableDefault Pageable page) {

//        ResultInfo resultInfo = tLargeAreaService.selectAllTLargeArea();

        Page<TLargeAreaModel> pageable = tLargeAreaService.selectAllpageLargeArea(page);

        ModelAndView modelAndView = new ModelAndView("/largeArea");
        modelAndView.addObject("totalPageNumber", pageable.getTotalElements());
        modelAndView.addObject("pageSize", pageable.getTotalPages());
        modelAndView.addObject("number", pageable.getNumber());
        modelAndView.addObject("largeAreaList", pageable.getContent());

        return modelAndView;

    }

    @RequestMapping(value = "/addView")
    public ModelAndView addView() {

        ModelAndView modelAndView = new ModelAndView("/newTLargeArea");
        return modelAndView;
    }

    @RequestMapping(value = "/newLargeArea")
    public ModelAndView newLargeArea(@Valid TLargeAreaModel largeAreaModel) {
        ResultInfo resultInfo = tLargeAreaService.saveLargeArea(largeAreaModel);

        ModelAndView modelAndView = new ModelAndView("redirect:/tLargeArea/selectLargeArea");
        modelAndView.addObject(resultInfo.getAppData());
        return modelAndView;
    }

    @RequestMapping(value = "/editLargeArea")
    public ModelAndView editLargeArea(@Valid TLargeAreaModel largeAreaModel) {
        ResultInfo resultInfo = tLargeAreaService.editLargeArea(largeAreaModel);

        ModelAndView modelAndView = new ModelAndView("redirect:/tLargeArea/selectLargeArea");
        modelAndView.addObject(resultInfo.getAppData());
        return modelAndView;
    }

    @RequestMapping(value = "/deleteById")
    public ModelAndView deleteDesignerById(@RequestParam Integer id) {
        ResultInfo resultInfo = tLargeAreaService.deleteLargeAreaById(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/tLargeArea/selectLargeArea");
        return modelAndView;
    }

    @RequestMapping(value = "/editView")
    public ModelAndView editView(@RequestParam Integer id) {

        ResultInfo resultInfo = tLargeAreaService.findById(id);

        ModelAndView modelAndView = new ModelAndView("/editTLargeArea");
        modelAndView.addObject("largeAreaModel", resultInfo.getAppData());
        return modelAndView;

    }

}
