package com.dxd.Service;

import com.dxd.po.Blog;
import com.dxd.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface Blogservice {

    Blog getBlog(Long id);

    Blog getAndConvert(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Long tagID,Pageable pageable);

    Page<Blog> listBlog(String query ,Pageable pageable);



    List<Blog> listRecommendBlogTop(Integer size);

    Map<String ,List<Blog>> archivesBlog();

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id,Blog blog);

    void deleteBlog(Long id);

    Long countBLog();
}
