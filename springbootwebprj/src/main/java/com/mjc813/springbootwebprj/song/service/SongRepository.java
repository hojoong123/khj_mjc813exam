package com.mjc813.springbootwebprj.song.service;

import com.mjc813.springbootwebprj.song.dto.SongEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<SongEntity, Long> {
    // Page<SongEntity> findBy~~~~~~~~~~(~~~~~~~, Pageable pageable);
    // title 컬럼의 이름이 포함되고, artist 컬럼의 이름이 포함되는 페이징 리스트 출력
    Page<SongEntity> findByTitleContainsAndArtistContains(String title, String arist, Pageable pageable);
}
