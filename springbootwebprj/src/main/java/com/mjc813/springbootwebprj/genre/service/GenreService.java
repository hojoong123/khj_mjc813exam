package com.mjc813.springbootwebprj.genre.service;

import com.mjc813.springbootwebprj.common.exception.MyDataNotFoundException;
import com.mjc813.springbootwebprj.common.exception.MyRequestException;
import com.mjc813.springbootwebprj.genre.dto.GenreDto;
import com.mjc813.springbootwebprj.genre.dto.GenreEntity;
import com.mjc813.springbootwebprj.genre.dto.IGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public IGenre insert(GenreDto dto) {
        if(dto == null) {
            return null;
        }
        // Dto 를 Entity 로 변환 해야만 JpaRepository 가 정상 실행된다.
        GenreEntity entity = GenreEntity.builder()
                .id(dto.getId())
                .name(dto.getName()).build();
        // Dto 를 Entity 로 변환 해야만 JpaRepository 가 정상 실행된다.
        this.genreRepository.save(entity);
        return entity;
    }

    public IGenre update(GenreDto dto) {
        // dto 의 id 번호로 데이터 있어야지만 수정이 가능하다.
        if (dto == null || dto.getId() == null) {
            throw new MyRequestException("parameter error");
        }
        Optional<GenreEntity> byId = this.genreRepository.findById(dto.getId());
        if( byId.isEmpty() ) {
            throw new MyDataNotFoundException(String.format("id[%d] can't found", dto.getId()));
        }
        // Dto 를 Entity 로 변환 해야만 JpaRepository 가 정상 실행된다.
        GenreEntity entity = byId.get();
        entity.setName(dto.getName());
        // Dto 를 Entity 로 변환 해야만 JpaRepository 가 정상 실행된다.
        this.genreRepository.save(entity);
        return entity;
    }

    public IGenre deleteById(Long id) {
        // dto 의 id 번호로 데이터 있어야지만 수정이 가능하다.
        if (id == null) {
            throw new MyRequestException("parameter error");
        }
        Optional<GenreEntity> byId = this.genreRepository.findById(id);
        if( byId.isEmpty() ) {
            throw new MyDataNotFoundException(String.format("id[%d] can't found", id));
        }
        this.genreRepository.deleteById(id);
        return byId.get();
    }

    public IGenre findById(Long id) {
        // dto 의 id 번호로 데이터 있어야지만 수정이 가능하다.
        if (id == null) {
            throw new MyRequestException("parameter error");
        }
        Optional<GenreEntity> byId = this.genreRepository.findById(id);
        if( byId.isEmpty() ) {
            throw new MyDataNotFoundException(String.format("id[%d] can't found", id));
        }
        return byId.get();
    }

    public Page<GenreEntity> findByNameContains(String name, Pageable pageable) {
        if (name == null || pageable == null) {
            throw new MyRequestException("parameter error");
        }
        Page<GenreEntity> list = this.genreRepository.findByNameContains(name, pageable);
        return list;
    }
}
