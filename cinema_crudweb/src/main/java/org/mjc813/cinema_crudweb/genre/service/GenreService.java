package org.mjc813.cinema_crudweb.genre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {
    @Autowired
    private GenreMybatisMapper genreMybatisMapper;
}
