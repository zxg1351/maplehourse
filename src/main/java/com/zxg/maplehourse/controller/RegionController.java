package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MAreaModel;
import com.zxg.maplehourse.model.MCityModel;
import com.zxg.maplehourse.model.MProvinceModel;
import com.zxg.maplehourse.model.MRoleModel;
import com.zxg.maplehourse.repository.MProvinceRepository;
import com.zxg.maplehourse.service.MRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 * 省、市、区列表查询
 */
@Controller
@RequestMapping(value = "/region")
public class RegionController {


    @Autowired
    private MRegionService mRegionService;

    //localhost:9091/

    /**
     * 查询省列表
     *
     * @return
     */
    @RequestMapping(value = "/selectProvice")
    public ModelAndView selectProvince(@PageableDefault Pageable pageNo) {


//        ResultInfo resultInfo = mRegionService.selectProvice();

        Page<MProvinceModel> pageable = mRegionService.selectPageProvince(pageNo);
        ModelAndView modelAndView = new ModelAndView("/province");
        modelAndView.addObject("totalPageNumber", pageable.getTotalElements());
        modelAndView.addObject("pageSize", pageable.getTotalPages());
        modelAndView.addObject("number", pageable.getNumber());
        modelAndView.addObject("mProvince", pageable.getContent());
        return modelAndView;
    }


    @RequestMapping(value = "/selectProviceBy")
    public ModelAndView selectProviceBy(@Valid MProvinceModel mProvinceModel) {


        Page<MProvinceModel> pageable = mRegionService.selectPageProvince(mProvinceModel.getMProvinceName());
        ModelAndView modelAndView = new ModelAndView("/province");/**/
        modelAndView.addObject("totalPageNumber", pageable.getTotalElements());
        modelAndView.addObject("pageSize", pageable.getTotalPages());
        modelAndView.addObject("number", pageable.getNumber());
        modelAndView.addObject("mProvince", pageable.getContent());
        return modelAndView;
    }


    /**
     * 查询区列表
     *
     * @return
     */
    @RequestMapping(value = "/selectArea")
    public ModelAndView selectMarea(@PageableDefault Pageable pageNo) {

//        ResultInfo resultInfo = mRegionService.selectArea();
        Page<MAreaModel> pageable = mRegionService.selectPageArea(pageNo);
        ModelAndView modelAndView = new ModelAndView("/area");
        modelAndView.addObject("totalPageNumber", pageable.getTotalElements());
        modelAndView.addObject("pageSize", pageable.getTotalPages());
        modelAndView.addObject("number", pageable.getNumber());
        modelAndView.addObject("arealist", pageable.getContent());

        return modelAndView;

    }

    /**
     * 查询市列表
     *
     * @return
     */
    @RequestMapping(value = "/selectCity")
    public ModelAndView selectCity(@PageableDefault Pageable pageNo) {

//        ResultInfo resultInfo = mRegionService.selectCity();
        Page<MCityModel> pageable = mRegionService.selectPageCity(pageNo);
        ModelAndView modelAndView = new ModelAndView("/city");
        modelAndView.addObject("totalPageNumber", pageable.getTotalElements());
        modelAndView.addObject("pageSize", pageable.getTotalPages());
        modelAndView.addObject("number", pageable.getNumber());
        modelAndView.addObject("citylist", pageable.getContent());

        return modelAndView;

    }


}
