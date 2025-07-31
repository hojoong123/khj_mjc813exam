package com.mjc813.cinema_crudweb.cinema.service;

import com.mjc813.cinema_crudweb.cinema.dto.CinemaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {
    @Autowired
    private CinemaMybatisMapper cinemaMybatisMapper;

    public void insertCinema(CinemaDto dto) {
        this.cinemaMybatisMapper.insertCinema(dto);
    }

    public CinemaDto findById(Long id) {
        return null;
    }
}
