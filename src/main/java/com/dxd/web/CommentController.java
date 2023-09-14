package com.dxd.web;


import com.dxd.Service.Blogservice;
import com.dxd.Service.CommentService;
import com.dxd.po.Comment;
import com.dxd.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {


    @Autowired
    private CommentService commentService;
    @Autowired
    private Blogservice blogservice;

    @Value("${comment.avatar}")
    private String avatar;

    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model){
        model.addAttribute("comments",commentService.listCommentByBlogId(blogId));

        return "blog :: commentList";
    }


    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session){
        Long blogId=comment.getBlog().getId();
        comment.setBlog(blogservice.getBlog(blogId));
        User user= (User) session.getAttribute("user");
        if (user==null){
            comment.setAvatar(avatar);
//            comment.setNickname(user.getNickname());
        }else {

            comment.setAdminComment(true);
            comment.setAvatar(avatar);
        }
        comment.setAvatar(avatar);
        commentService.saveComment(comment);
        return "redirect:/comments/"+comment.getBlog().getId();
    }
}
