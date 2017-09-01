package com.zxg.maplehourse.controller;


import com.zxg.maplehourse.model.MCityModel;
import com.zxg.maplehourse.repository.MCityRepository;
import com.zxg.maplehourse.repository.MProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/test")
public class TestController {


    @Autowired
    private MCityRepository mProvinceRepository;

    //@RequestParam(value = "pageNo") int pageNo
    @RequestMapping(value = "/select")
    private ModelAndView selectP(@PageableDefault Pageable pageNo) {

        int page = 0;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
//        if (pageNo.getPageNumber() < page) {
//
//            pageNo.getPageNumber() = page;
//        }
//        Pageable pageable = new PageRequest(pageNo, 10);

        Page<MCityModel> mCityModels = mProvinceRepository.findAll(pageNo);

        ModelAndView modelAndView = new ModelAndView("/city");
        modelAndView.addObject("citylist", mCityModels.getContent());
        modelAndView.addObject("totalPageNumber", mCityModels.getTotalElements());
        modelAndView.addObject("pageSize", mCityModels.getTotalPages());
        modelAndView.addObject("number", mCityModels.getNumber());
        return modelAndView;

    }


}
