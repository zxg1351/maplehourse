package com.zxg.maplehourse.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.model.MRoleModel;
import com.zxg.maplehourse.model.MUserModel;
import com.zxg.maplehourse.service.MRoleService;
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
 * 角色列表
 */
@Controller
@RequestMapping(value = "/mRole")
public class MRoleController {

    @Autowired
    private MRoleService mRoleService;

    /**
     * 查询角色列表
     *
     * @return
     */
    @RequestMapping(value = "/selectRole")
    public ModelAndView selectRole(@PageableDefault Pageable pageNo) {

        Page<MRoleModel> pageable = mRoleService.selectPageRole(pageNo);

        ModelAndView modelAndView = new ModelAndView("/role");
        modelAndView.addObject("totalPageNumber", pageable.getTotalElements());
        modelAndView.addObject("pageSize", pageable.getTotalPages());
        modelAndView.addObject("number", pageable.getNumber());
        modelAndView.addObject("roleList", pageable.getContent());

        return modelAndView;
    }


    @RequestMapping(value = "/addRole")
    public ModelAndView addRole() {
        ModelAndView modelAndView = new ModelAndView("/newRole");
        return modelAndView;
    }


    @RequestMapping(value = "/newRoles")
    public ModelAndView addRoles(@Valid MRoleModel mRoleModel) {

        ResultInfo resultInfo = mRoleService.saveRole(mRoleModel);

        ModelAndView modelAndView = new ModelAndView("redirect:/mRole/selectRole");
        modelAndView.addObject(resultInfo.getAppData());
        return modelAndView;

    }

    @RequestMapping(value = "/editView")
    public ModelAndView editView(@RequestParam Integer roleId) {
        ResultInfo resultInfo = mRoleService.findById(roleId);
        ModelAndView modelAndView = new ModelAndView("/editRole");
        modelAndView.addObject("mRoleModel", resultInfo.getAppData());
        return modelAndView;

    }


    @RequestMapping(value = "/editRole")
    public ModelAndView editRole(@Valid MRoleModel mRoleModel) {

        ResultInfo resultInfo = mRoleService.editRole(mRoleModel);
        ModelAndView modelAndView = new ModelAndView("redirect:/mRole/selectRole");
        modelAndView.addObject(resultInfo.getAppData());
        return modelAndView;
    }

    @RequestMapping(value = "/deleteRoleById")
    public ModelAndView deleteRoleById(@RequestParam Integer roleId) {


        ResultInfo resultInfo = mRoleService.deleteRoleById(roleId);

        ModelAndView modelAndView = new ModelAndView("redirect:/mRole/selectRole");

        return modelAndView;
    }

    @RequestMapping(value = "/searchList")
    public ModelAndView searchList(@Valid MRoleModel mRoleModel) {
        Page<MRoleModel> pageable = mRoleService.selectRole(mRoleModel);
        ModelAndView modelAndView = new ModelAndView("/role");/**/
        modelAndView.addObject("totalPageNumber", pageable.getTotalElements());
        modelAndView.addObject("pageSize", pageable.getTotalPages());
        modelAndView.addObject("number", pageable.getNumber());
        modelAndView.addObject("roleList", pageable.getContent());
        return modelAndView;
    }

}
