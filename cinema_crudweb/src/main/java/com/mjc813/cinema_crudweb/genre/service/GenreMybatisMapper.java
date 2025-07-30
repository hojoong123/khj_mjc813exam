package com.mjc813.cinema_crudweb.genre.service;

import com.mjc813.cinema_crudweb.genre.dto.GenreDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GenreMybatisMapper {
    public void insert(GenreDto dto);
}
