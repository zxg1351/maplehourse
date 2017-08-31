package com.zxg.maplehourse.controller;


import com.zxg.maplehourse.model.MCityModel;
import com.zxg.maplehourse.repository.MCityRepository;
import com.zxg.maplehourse.repository.MProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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


    @RequestMapping(value = "/select")
    private Page<MCityModel> selectP(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                     @RequestParam(value = "size", defaultValue = "15") Integer size) {


        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);


        Page<MCityModel> mCityModels = mProvinceRepository.findAll(pageable);
        return mCityModels;

    }


}
