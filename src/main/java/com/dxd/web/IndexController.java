package com.dxd.web;



import com.dxd.Service.Blogservice;
import com.dxd.Service.TagService;
import com.dxd.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/search")
    public String search(@PageableDefault(size =8,sort = {"updateTime"},direction = Sort.Direction.DESC)Pageable pageable,
                         @RequestParam String query, Model model){
        model.addAttribute("page",blogservice.listBlog("%"+query+"%",pageable));
        model.addAttribute("query",query);

        return "search";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id,Model model){
        model.addAttribute("blog",blogservice.getAndConvert(id));
        return "blog";
    }


    @GetMapping("/footer/newblog")
    public String newblogs(Model model){

        model.addAttribute("newblogs",blogservice.listRecommendBlogTop(3));
        System.out.println("霓虹");
        return "_fragments :: newblogList";
    }
}
