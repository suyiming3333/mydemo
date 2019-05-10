package com.sym.mydemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PreDestroy;


/**
 * @author suyiming3333@gmail.com
 * @version V1.0
 * @Title: DemoContrller
 * @Package com.sym.mydemo.controller
 * @Description: TODO
 * @date 2019/5/9 23:18
 */

@Controller
@RequestMapping("/user")
public class UserContrller {

//    @PreAuthorize("hasRole('USER')")
//    @PreAuthorize("hasAuthority('book-view1')")
    @RequestMapping("/index")
    public String themaleaf(Model model) {
        model.addAttribute("name", "Joshua");
        return "user/index";
    }
}
