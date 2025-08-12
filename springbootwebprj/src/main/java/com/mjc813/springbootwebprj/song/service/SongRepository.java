package com.mjc813.springbootwebprj.song.service;

import com.mjc813.springbootwebprj.song.dto.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<SongEntity, Long> {
}
