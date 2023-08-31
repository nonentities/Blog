package com.dxd.web;


import com.dxd.NotFoundException;
import com.dxd.Service.Blogservice;
import com.dxd.Service.TagService;
import com.dxd.Service.TypeService;
import com.dxd.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Create by dxd on 2023-08-23
 */
@Controller
public class IndexController {

    @Autowired
    private Blogservice blogservice;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String index(@PageableDefault(size =8,sort = {"updateTime"},direction = Sort.Direction.DESC)Pageable pageable,
                        Model model) {
        model.addAttribute("page",blogservice.listBlog(pageable));
        model.addAttribute("types",typeService.listTypeTop(6));
        model.addAttribute("tags",tagService.listTagTop(10));
        model.addAttribute("recommendBlogs",blogservice.listRecommendBlogTop(8));
        return "index";
    }

    @GetMapping("/blog/{id}")
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
