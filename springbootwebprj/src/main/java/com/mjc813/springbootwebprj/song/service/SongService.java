package com.mjc813.springbootwebprj.song.service;

import com.mjc813.springbootwebprj.common.exception.MyDataNotFoundException;
import com.mjc813.springbootwebprj.common.exception.MyRequestException;
import com.mjc813.springbootwebprj.song.dto.ISong;
import com.mjc813.springbootwebprj.song.dto.SongDto;
import com.mjc813.springbootwebprj.song.dto.SongEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private SongMybatisMapper songMybatisMapper;


    public ISong insert(SongDto dto) {
        //return this.insertRepository(dto);
        return this.insertMybatis(dto);
    }

    private ISong insertRepository(SongDto dto) {
        SongEntity entity = new SongEntity();
        entity.copyMembers(dto);
        this.songRepository.save(entity);
        return entity;
    }

    private ISong insertMybatis(SongDto dto) {
        this.songMybatisMapper.insert(dto);
        return dto;
    }

    public ISong update(SongDto dto) {
        // dto 의 id 번호로 데이터 있어야지만 수정이 가능하다.
        if (dto == null || dto.getId() == null) {
            throw new MyRequestException("parameter error");
        }
        //return this.updateRepository(dto);
        return this.updateMybatis(dto);
    }

    private ISong updateRepository(SongDto dto) {
        // Dto 를 Entity 로 변환 해야만 JpaRepository 가 정상 실행된다.
        SongEntity entity = (SongEntity)this.findByIdRepository(dto.getId());
        entity.copyMembersNotNull(dto);
        this.songRepository.save(entity);
        return entity;
    }

    private ISong updateMybatis(SongDto dto) {
        ISong find = this.findByIdMybatis(dto.getId());
        find.copyMembersNotNull(dto);
        this.songMybatisMapper.update((SongDto)find);
        return find;
    }

    public ISong deleteById(Long id) {
        if (id == null) {
            throw new MyRequestException("parameter error");
        }
        //return this.deleteByIdRepository(id);
        return this.deleteByIdMybatis(id);
    }

    private ISong deleteByIdRepository(Long id) {
        // Dto 를 Entity 로 변환 해야만 JpaRepository 가 정상 실행된다.
        SongEntity entity = (SongEntity)this.findByIdRepository(id);
        this.songRepository.deleteById(id);
        return entity;
    }

    private ISong deleteByIdMybatis(Long id) {
        ISong find = this.findByIdMybatis(id);
        this.songMybatisMapper.deleteById(id);
        return find;
    }

    public ISong findById(Long id) {
        //return this.findByIdRepository(id);
        return this.findByIdMybatis(id);
    }

    private ISong findByIdRepository(Long id) {
        if (id == null) {
            throw new MyRequestException("parameter error");
        }
        Optional<SongEntity> byId = this.songRepository.findById(id);
        if( byId.isEmpty() ) {
            throw new MyDataNotFoundException(String.format("id[%d] can't found", id));
        }
        // Dto 를 Entity 로 변환 해야만 JpaRepository 가 정상 실행된다.
        SongEntity entity = byId.get();
        return entity;
    }

    private ISong findByIdMybatis(Long id) {
        if (id == null) {
            throw new MyRequestException("parameter error");
        }
        ISong find = this.songMybatisMapper.findById(id);
        if( find == null ) {
            throw new MyDataNotFoundException(String.format("id[%d] can't found", id));
        }
        return find;

    }

    public Page<ISong> findByTitleContainsAndArtistContains(String title, String artist, Pageable pageable) {
        //return this.findByTitleContainsAndArtistContainsRepository(title, artist, pageable);
        return this.findByTitleContainsAndArtistContainsMybatis(title, artist, pageable);
    }

    private Page<ISong> findByTitleContainsAndArtistContainsRepository(String title, String artist, Pageable pageable) {
        if (title == null || artist == null || pageable == null) {
            throw new MyRequestException("parameter error");
        }
        Page<SongEntity> page = this.songRepository.findByTitleContainsAndArtistContains(title, artist, pageable);
        List<ISong> list = page.getContent().parallelStream()
                .map(x -> (ISong)x).toList();
        return new PageImpl<>(list, pageable, page.getTotalElements());
    }

    private Page<ISong> findByTitleContainsAndArtistContainsMybatis(String title, String artist, Pageable pageable) {
        if (title == null || artist == null || pageable == null) {
            throw new MyRequestException("parameter error");
        }
        List<ISong> list = this.songMybatisMapper.findByNameContainsAndArtistContains(title, artist, pageable);
        Long total = this.songMybatisMapper.countByNameContainsAndArtistContains(title, artist);
        return new PageImpl<>(list, pageable, total);
    }
}
