package com.lirchis.blogapi.mapper;

import com.lirchis.blogapi.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findByUsername(String username);

    User findById(Long userid);
}
