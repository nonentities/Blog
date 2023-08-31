package com.dxd.Service;

import com.dxd.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {

    Type saveType(Type type);
    //查询
    Type getType(Long id);

    Type getTypeByName(String name);

    List<Type> listType();

    List<Type> listTypeTop(Integer size);

    //分页查询
    Page<Type> listType(Pageable pageable);
    //修改
    Type updateType(Long id,Type type);
    //删除
    void deleteType(Long id);
}
