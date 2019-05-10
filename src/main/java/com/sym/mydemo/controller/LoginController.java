package com.sym.mydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author suyiming3333@gmail.com
 * @version V1.0
 * @Title: LoginController
 * @Package com.sym.mydemo.controller
 * @Description: TODO
 * @date 2019/5/10 21:38
 */

@Controller
public class LoginController {

    // index page
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    // Login form
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
