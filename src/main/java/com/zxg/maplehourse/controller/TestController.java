package com.zxg.maplehourse.controller;


import com.zxg.maplehourse.model.MCityModel;
import com.zxg.maplehourse.repository.MCityRepository;
import com.zxg.maplehourse.repository.MProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.*;
import java.util.List;

@RestController
@RequestMapping(value = "/test")
public class TestController {


    @Autowired
    private MCityRepository mCityRepository;

    //@RequestParam(value = "pageNo") int pageNo
    @RequestMapping(value = "/select")
    private ModelAndView selectP(@PageableDefault Pageable pageNo, @PageableDefault MCityModel mCityModel) {


        Page<MCityModel> mCityModels = mCityRepository.findAll(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {

                Expression<String> mCityName = root.get("mCityName").as(String.class);

                Predicate predicate = criteriaBuilder.like(mCityName, "%" + mCityModel.getMCityName() + "%");

                criteriaQuery.where(predicate);
                return null;
            }
        }, new PageRequest(0, 10));


        ModelAndView modelAndView = new ModelAndView("/cityTest");
        modelAndView.addObject("citylist", mCityModels.getContent());
        modelAndView.addObject("totalPageNumber", mCityModels.getTotalElements());
        modelAndView.addObject("pageSize", mCityModels.getTotalPages());
        modelAndView.addObject("number", mCityModels.getNumber());
        return modelAndView;

    }


}
