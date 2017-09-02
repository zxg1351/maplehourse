package com.zxg.maplehourse.controller;


import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.common.utils.SecurityUtil;
import com.zxg.maplehourse.model.MUserModel;
import com.zxg.maplehourse.model.User;
import com.zxg.maplehourse.service.MUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class MUserController {

    @Autowired
    private MUserService mUserService;

    @GetMapping
    public ModelAndView toLoginForm(@ModelAttribute("errorMsg") String errorMsg, @ModelAttribute("user") MUserModel mUserModel) {


        //返回templates/login.html 页面, html 可以省略
        return new ModelAndView("/login");


    }
    @RequestMapping(value = "/login")
    public ModelAndView login(HttpServletRequest request, @Valid MUserModel mUserModel, BindingResult result, RedirectAttributes redirectAttributes) {


        //如果user的字段不符合要求，则返回登录页面，并将var并将 valid error 信息传入登录页面
        if (result.hasErrors()) {

            return new ModelAndView("/login", "formErrors", result.getAllErrors());
        }
        //用户名或密码不正确
//        if (!User.isUserValid(mUserModel)) {
//
//            //添加错误信息，该消息将 一起带到重定向后的 页面
//            //浏览器刷新后，该数据将消失
//            redirectAttributes.addFlashAttribute("errorMsg", "登录失败，,用户名或密码错误");
//            return new ModelAndView("redirect:/user");
//        }

        ResultInfo resultInfo = mUserService.checkUser(mUserModel);
        if ("success".equals(resultInfo.getResultCode())) {

            //将用户登录信息添加到session中
            request.getSession().setAttribute("userLogin", true);

        } else {

            return new ModelAndView("redirect:/user");
        }
        return new ModelAndView("redirect:/mMenu/selectMenu");

    }


    @RequestMapping(value = "/selectUserList")
    public ModelAndView selectUserList() {

        ResultInfo resultInfo = mUserService.selectAllUser();
        ModelAndView modelAndView = new ModelAndView("/user");
        modelAndView.addObject("userList", resultInfo.getAppData());
        return modelAndView;

    }

    @RequestMapping(value = "/insertUser")
    public ModelAndView insertUser(HttpServletRequest request, @Valid MUserModel mUserModel) {

        ResultInfo resultInfo = mUserService.saveUser(mUserModel);
        ModelAndView modelAndView = new ModelAndView("redirect:/user/selectUserList");
        modelAndView.addObject(resultInfo.getAppData());
        return modelAndView;


    }


    @RequestMapping(value = "/newUser")
    public ModelAndView newUser() {
        //返回templates/login.html 页面, html 可以省略
        return new ModelAndView("/newUser");
    }
}



