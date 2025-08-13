package com.mjc813.springbootwebprj.song.controller;

import com.mjc813.springbootwebprj.common.CommonRestController;
import com.mjc813.springbootwebprj.common.ResponseDto;
import com.mjc813.springbootwebprj.common.ResponseEnumCode;
import com.mjc813.springbootwebprj.common.exception.MyDataNotFoundException;
import com.mjc813.springbootwebprj.common.exception.MyRequestException;
import com.mjc813.springbootwebprj.song.dto.ISong;
import com.mjc813.springbootwebprj.song.dto.SongDto;
import com.mjc813.springbootwebprj.song.dto.SongEntity;
import com.mjc813.springbootwebprj.song.service.SongService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping("/song")
public class SongRestController extends CommonRestController {
    @Autowired
    private SongService songService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(@Validated @RequestBody SongDto dto) {
        try {
            ISong isong = this.songService.insert(dto);
            return getResponseEntity(ResponseEnumCode.SUCCESS, "OK", isong);
        } catch (Throwable e) {
            return getResponseEntity(log, e, ResponseEnumCode.INSERT_ERROR, "ERROR", dto);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> update(
            @PathVariable Long id
            , @Validated @RequestBody SongDto dto) {
        try {
            if ( dto.getId() == null || !id.equals(dto.getId()) ) {
                return getResponseEntity(ResponseEnumCode.REQUEST_ERROR, "ERROR", id);
            }
            ISong iSong = this.songService.update(dto);
            return getResponseEntity(ResponseEnumCode.SUCCESS, "OK", iSong);
        } catch (MyRequestException e) {
            return getResponseEntity(log, e, ResponseEnumCode.REQUEST_ERROR, "ERROR", id);
        } catch (MyDataNotFoundException e) {
            return getResponseEntity(log, e, ResponseEnumCode.DATA_NOTFOUND_ERROR, "ERROR", id);
        } catch (Throwable e) {
            log.error(e.toString());
            return getResponseEntity(log, e, ResponseEnumCode.UPDATE_ERROR, "ERROR", id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Long id) {
        try {
            ISong find = this.songService.deleteById(id);
            return getResponseEntity(ResponseEnumCode.SUCCESS, "OK", id);
        } catch (MyRequestException e) {
            return getResponseEntity(log, e, ResponseEnumCode.REQUEST_ERROR, "ERROR", id);
        } catch (MyDataNotFoundException e) {
            return getResponseEntity(log, e, ResponseEnumCode.DATA_NOTFOUND_ERROR, "ERROR", id);
        } catch (Throwable e) {
            log.error(e.toString());
            return getResponseEntity(log, e, ResponseEnumCode.DELETE_ERROR, "ERROR", id);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Long id) {
        try {
            ISong find = this.songService.findById(id);
            return getResponseEntity(ResponseEnumCode.SUCCESS, "OK", find);
        } catch (MyRequestException e) {
            return getResponseEntity(log, e, ResponseEnumCode.REQUEST_ERROR, "ERROR", id);
        } catch (MyDataNotFoundException e) {
            return getResponseEntity(log, e, ResponseEnumCode.DATA_NOTFOUND_ERROR, "ERROR", id);
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
            Page<ISong> list = this.songService.findByTitleContainsAndArtistContains(title, artist, pageable);
            return getResponseEntity(ResponseEnumCode.SUCCESS, "OK", list);
        } catch (MyRequestException e) {
            return getResponseEntity(log, e, ResponseEnumCode.REQUEST_ERROR, "ERROR", null);
        } catch (Throwable e) {
            log.error(e.toString());
            return getResponseEntity(log, e, ResponseEnumCode.SELECT_ERROR, "ERROR", null);
        }
    }
}
