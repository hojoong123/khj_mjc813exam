package com.mjc813.springbootwebprj.song.controller;

import com.mjc813.springbootwebprj.common.CommonRestController;
import com.mjc813.springbootwebprj.common.ResponseDto;
import com.mjc813.springbootwebprj.common.ResponseEnumCode;
import com.mjc813.springbootwebprj.song.dto.SongEntity;
import com.mjc813.springbootwebprj.song.service.SongRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping("/song")
public class SongRestController extends CommonRestController {
    @Autowired
    private SongRepository songRepository;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(@RequestBody SongEntity entity) {
        try {
            this.songRepository.save(entity);
            return getResponseEntity(ResponseEnumCode.SUCCESS, "OK", entity);
        } catch (Throwable e) {
            return getResponseEntity(log, e, ResponseEnumCode.INSERT_ERROR, "ERROR", entity);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> update(
            @PathVariable Long id
            , @RequestBody SongEntity entity) {
        try {
            if (entity.getId() == null && !id.equals(entity.getId())) {
                return getResponseEntity(ResponseEnumCode.REQUEST_ERROR, "ERROR", id);
            }
            Optional<SongEntity> find = this.songRepository.findById(id);
            if (find.isEmpty()) {
                return getResponseEntity(ResponseEnumCode.DATA_NOTFOUND_ERROR, "ERROR", id);
            } else {
                entity.setId(id);
                this.songRepository.save(entity);
                return getResponseEntity(ResponseEnumCode.SUCCESS, "OK", entity);
            }
        } catch (Throwable e) {
            log.error(e.toString());
            return getResponseEntity(log, e, ResponseEnumCode.UPDATE_ERROR, "ERROR", id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Long id) {
        try {
            Optional<SongEntity> find = this.songRepository.findById(id);
            if (find.isEmpty()) {
                return getResponseEntity(ResponseEnumCode.DATA_NOTFOUND_ERROR, "ERROR", id);
            } else {
                this.songRepository.deleteById(id);
                return getResponseEntity(ResponseEnumCode.SUCCESS, "OK", id);
            }
        } catch (Throwable e) {
            log.error(e.toString());
            return getResponseEntity(log, e, ResponseEnumCode.DELETE_ERROR, "ERROR", id);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Long id) {
        try {
            Optional<SongEntity> find = this.songRepository.findById(id);
            if (find.isEmpty()) {
                return getResponseEntity(ResponseEnumCode.DATA_NOTFOUND_ERROR, "ERROR", null);
            } else {
                return getResponseEntity(ResponseEnumCode.SUCCESS, "OK", find.get());
            }
        } catch (Throwable e) {
            log.error(e.toString());
            return getResponseEntity(log, e, ResponseEnumCode.SELECT_ERROR, "ERROR", id);
        }
    }

    @GetMapping("")
    public ResponseEntity<ResponseDto> findByTitleContainsAndArtistContains(
            @RequestParam("title") String title
            , @RequestParam("artist") String artist
            , Pageable pageable
    ) {
        try {
            Page<SongEntity> list = this.songRepository.findByTitleContainsAndArtistContains(title, artist, pageable);
            return getResponseEntity(ResponseEnumCode.SUCCESS, "OK", list);
        } catch (Throwable e) {
            log.error(e.toString());
            return getResponseEntity(log, e, ResponseEnumCode.SELECT_ERROR, "ERROR", null);
        }
    }
}
