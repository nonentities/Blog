package com.dxd.web;


import com.dxd.Service.Blogservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArchivesShowController {


    @Autowired
    private Blogservice blogservice;

    @GetMapping("/archives")
    public String archives(Model model){

        model.addAttribute("archiveMap",blogservice.archivesBlog());
        model.addAttribute("blogCount",blogservice.countBLog());
        return "archives";
    }
}
