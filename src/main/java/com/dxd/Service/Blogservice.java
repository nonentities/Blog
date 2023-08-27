package com.dxd.Service;

import com.dxd.po.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Blogservice {

    Blog getBlog(Long id);

    Page<Blog> listBlog(Pageable pageable,Blog blog);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id,Blog blog);

    void deleteBlog(Long id);
}
