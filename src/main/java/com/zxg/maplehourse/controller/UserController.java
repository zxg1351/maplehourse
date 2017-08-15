package com.zxg.maplehourse.controller;

import com.zxg.maplehourse.Model.Apple;
import com.zxg.maplehourse.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {


    @GetMapping
    public ModelAndView toLoginForm(@ModelAttribute("errorMsg") String errorMsg, @ModelAttribute("user") User user) {


        //返回templates/login.html 页面, html 可以省略
        return new ModelAndView("/login");


    }


    @PostMapping("/login")
    public ModelAndView login(HttpServletRequest request, @Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {


        //如果user的字段不符合要求，则返回登录页面，并将var并将 valid error 信息传入登录页面
        if (result.hasErrors()){

            return new ModelAndView("/login", "formErrors", result.getAllErrors());
        }
        //用户名或密码不正确
        if (!User.isUserValid(user)){

            //添加错误信息，该消息将 一起带到重定向后的 页面
            //浏览器刷新后，该数据将消失
            redirectAttributes.addFlashAttribute("errorMsg","登录失败，,用户名或密码错误");
            return  new ModelAndView("redirect:/user");
        }

       //将用户登录信息添加到session中
        request.getSession().setAttribute("userLogin",true);
        return  new ModelAndView("redirect:/user/apples");

        //
    }


    @GetMapping("/apples")
    public ModelAndView apples(HttpServletRequest request){


        Boolean userLogin =(Boolean) request.getSession().getAttribute("userLogin");


        if (userLogin!=null && userLogin){

            List<Apple> apples = Apple.generateApples();
            //登录成功，进入apple页面并展示apples
            ModelAndView modelAndView = new ModelAndView("/apple");
            modelAndView.addObject("apples",apples);
            return modelAndView;

        }

        return new ModelAndView("redirect:/user");


    }















}
