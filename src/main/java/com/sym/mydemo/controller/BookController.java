package com.sym.mydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author suyiming3333@gmail.com
 * @version V1.0
 * @Title: BookController
 * @Package com.sym.mydemo.controller
 * @Description: TODO
 * @date 2019/5/12 20:25
 */

@Controller
@RequestMapping("/book")
public class BookController {

    @RequestMapping("/list")
    public String bookList(){
        return "book/booklist";
    }
}
