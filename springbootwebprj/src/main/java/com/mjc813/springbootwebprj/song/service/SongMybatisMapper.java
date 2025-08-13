package com.mjc813.springbootwebprj.song.service;

import com.mjc813.springbootwebprj.song.dto.ISong;
import com.mjc813.springbootwebprj.song.dto.SongDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Mapper
public interface SongMybatisMapper {
    void insert(SongDto dto);
    void update(SongDto dto);
    void deleteById(Long id);
    ISong findById(Long id);
    List<ISong> findByNameContainsAndArtistContains(String title, String artist, Pageable pageable);
    Long countByNameContainsAndArtistContains(String title, String artist);
}
