package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.model.MProvinceModel;
import com.zxg.maplehourse.repository.MProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RequestMapping(value = "/region")
public class RegionController {

    @Autowired
    private MProvinceRepository mProvinceRepository;

    //localhost:9091/
    @RequestMapping(value = "/selectProvice")
    public ModelAndView selectProvince() {

        List<MProvinceModel> mProvinceModelList = mProvinceRepository.findAllBy();

        ModelAndView modelAndView = new ModelAndView("/province");
        modelAndView.addObject("mProvince",mProvinceModelList);
        return modelAndView;
    }




}
