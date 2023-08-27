package com.dxd.Service;

import com.dxd.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeService {

    Type saveType(Type type);
    //查询
    Type getType(Long id);

    Type getTypeByName(String name);
    //分页查询
    Page<Type> listType(Pageable pageable);
    //修改
    Type updateType(Long id,Type type);
    //删除
    void deleteType(Long id);
}
