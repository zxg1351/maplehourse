package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MBannerModel;
import com.zxg.maplehourse.model.MRoleModel;
import com.zxg.maplehourse.service.MBannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by Administrator on 2017/8/18.
 * 轮播图列表
 */
@Controller
@RequestMapping(value = "/mBanner")
public class MBannerController {


    @Autowired
    private MBannerService mBannerService;

    /**
     * 查询轮播图
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/selectBanner")
    public ModelAndView selectBanner(HttpServletRequest request, @PageableDefault Pageable pageNo) {
        String name = "";

//        ResultInfo resultInfo = mBannerService.selectAllBanner(name);
        Page<MBannerModel> pageable = mBannerService.selectPageBanner(pageNo);
        ModelAndView modelAndView = new ModelAndView("/banner");
        modelAndView.addObject("totalPageNumber", pageable.getTotalElements());
        modelAndView.addObject("pageSize", pageable.getTotalPages());
        modelAndView.addObject("number", pageable.getNumber());
        modelAndView.addObject("mbannerList", pageable.getContent());
        return modelAndView;
    }

    @RequestMapping(value = "/addBanner")
    public ModelAndView addRole() {

        ModelAndView modelAndView = new ModelAndView("/newBanner");
        return modelAndView;
    }


    @RequestMapping(value = "/insertBanner")
    public ModelAndView insertBanner(@Valid MBannerModel mBannerModel) {
        mBannerModel.setDelFlag("0");
        ResultInfo resultInfo = mBannerService.insertBanner(mBannerModel);

        ModelAndView modelAndView = new ModelAndView("redirect:/mBanner/selectBanner");
        modelAndView.addObject(resultInfo.getAppData());

        return modelAndView;
    }

    @RequestMapping(value = "/editView")
    public ModelAndView editView(@RequestParam Integer mbannerId) {

        ResultInfo resultInfo = mBannerService.findById(mbannerId);
        ModelAndView modelAndView = new ModelAndView("/editBanner");

        modelAndView.addObject("mBannerModel", resultInfo.getAppData());
        return modelAndView;
    }

    @RequestMapping(value = "/editBanner")
    public ModelAndView editBanner(@Valid MBannerModel mBannerModel) {


        ResultInfo resultInfo = mBannerService.editBanner(mBannerModel);
        ModelAndView modelAndView = new ModelAndView("redirect:/mBanner/selectBanner");
        modelAndView.addObject(resultInfo.getAppData());
        return modelAndView;
    }


    @RequestMapping(value = "/deleteById")
    public ModelAndView deleteById(@RequestParam Integer mbannerId) {
        ResultInfo resultInfo = mBannerService.deleteById(mbannerId);

        ModelAndView modelAndView = new ModelAndView("redirect:/mBanner/selectBanner");
        return modelAndView;
    }

    @RequestMapping(value = "/searchList")
    public ModelAndView searchList(@Valid MBannerModel bannerModel) {
        Page<MBannerModel> pageable = mBannerService.selectBanner(bannerModel);
        ModelAndView modelAndView = new ModelAndView("/banner");/**/
        modelAndView.addObject("totalPageNumber", pageable.getTotalElements());
        modelAndView.addObject("pageSize", pageable.getTotalPages());
        modelAndView.addObject("number", pageable.getNumber());
        modelAndView.addObject("mbannerList", pageable.getContent());
        return modelAndView;
    }
}
