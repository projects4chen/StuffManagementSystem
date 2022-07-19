package com.chen.controller;

import com.chen.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        Model model, HttpSession session){
        // 获取用户名密码
        String pwd = userMapper.getPwd(username);
        // 密码匹配
        if (!StringUtils.isEmpty(username) && (!StringUtils.isEmpty(pwd)) && pwd.equals(password)){
            session.setAttribute("loginUser", username);
            return "redirect:/user/main";
        }else {
            // 登录失败
            model.addAttribute("msg", "用户名或密码错误");
            return "index";
        }
    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
