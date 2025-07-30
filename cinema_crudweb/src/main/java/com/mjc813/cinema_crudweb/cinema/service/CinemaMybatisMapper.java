package com.mjc813.cinema_crudweb.cinema.service;

import com.mjc813.cinema_crudweb.cinema.dto.CinemaDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CinemaMybatisMapper {
    public void insertCinema(CinemaDto dto);
}

