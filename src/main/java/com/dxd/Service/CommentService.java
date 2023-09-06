package com.dxd.Service;

import com.dxd.po.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);


    Comment saveComment(Comment comment);
}
