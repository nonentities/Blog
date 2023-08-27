package com.dxd.Dao;

import com.dxd.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository  extends JpaRepository<Type,Long> {
    Type findByName(String name);
}
