package com.dxd.web;


import com.dxd.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Create by dxd on 2023-08-23
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() throws NotFoundException {
//        int i=9/0;
//        String blog=null;
//        if (blog==null){
//            throw  new NotFoundException("博客不存在");
//        }
//        System.out.println("----index----");
        return "index";
    }

    @GetMapping("/blog")
    public String blog() throws NotFoundException {
//        int i=9/0;
//        String blog=null;
//        if (blog==null){
//            throw  new NotFoundException("博客不存在");
//        }
//        System.out.println("----index----");
        return "blog";
    }
}
