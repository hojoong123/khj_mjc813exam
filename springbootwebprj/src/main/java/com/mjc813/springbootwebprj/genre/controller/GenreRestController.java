package com.mjc813.springbootwebprj.genre.controller;

import com.mjc813.springbootwebprj.common.CommonRestController;
import com.mjc813.springbootwebprj.common.ResponseDto;
import com.mjc813.springbootwebprj.common.ResponseEnumCode;
import com.mjc813.springbootwebprj.common.exception.MyDataNotFoundException;
import com.mjc813.springbootwebprj.common.exception.MyRequestException;
import com.mjc813.springbootwebprj.genre.dto.GenreDto;
import com.mjc813.springbootwebprj.genre.dto.GenreEntity;
import com.mjc813.springbootwebprj.genre.dto.IGenre;
import com.mjc813.springbootwebprj.genre.service.GenreRepository;
import com.mjc813.springbootwebprj.genre.service.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import jakarta.security.auth.message.callback.PrivateKeyCallback;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/genre")
public class GenreRestController extends CommonRestController {
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private GenreService genreService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(@RequestBody GenreDto dto) {
        try {
            IGenre igenre = this.genreService.insert(dto);
            return getResponseEntity(ResponseEnumCode.SUCCESS, "OK", igenre);
        } catch (Throwable e) {
            return getResponseEntity(log, e, ResponseEnumCode.INSERT_ERROR, "ERROR", dto);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable("id") Long id, @RequestBody GenreDto dto) {
        try {
            if ( dto.getId() == null && !id.equals(dto.getId()) ) {
                return getResponseEntity(ResponseEnumCode.REQUEST_ERROR, "ERROR", id);
            }
            IGenre igenre = this.genreService.update(dto);
            return getResponseEntity(ResponseEnumCode.SUCCESS, "OK", igenre);
        } catch (MyRequestException e) {
            return getResponseEntity(log, e, ResponseEnumCode.REQUEST_ERROR, "ERROR", dto);
        } catch (MyDataNotFoundException e) {
            return getResponseEntity(log, e, ResponseEnumCode.DATA_NOTFOUND_ERROR, "ERROR", dto);
        } catch (Throwable e) {
            return getResponseEntity(log, e, ResponseEnumCode.UPDATE_ERROR, "ERROR", dto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Long id) {
        try {
            this.genreService.deleteById(id);
            return getResponseEntity(ResponseEnumCode.SUCCESS, "OK", id);
        } catch (MyRequestException e) {
            return getResponseEntity(log, e, ResponseEnumCode.REQUEST_ERROR, "ERROR", id);
        } catch (MyDataNotFoundException e) {
            return getResponseEntity(log, e, ResponseEnumCode.DATA_NOTFOUND_ERROR, "ERROR", id);
        } catch (Throwable e) {
            return getResponseEntity(log, e, ResponseEnumCode.DELETE_ERROR, "ERROR", id);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Long id) {
        try {
            IGenre iFind = this.genreService.findById(id);
            return getResponseEntity(ResponseEnumCode.SUCCESS, "OK", iFind);
        } catch (MyRequestException e) {
            return getResponseEntity(log, e, ResponseEnumCode.REQUEST_ERROR, "ERROR", id);
        } catch (MyDataNotFoundException e) {
            return getResponseEntity(log, e, ResponseEnumCode.DATA_NOTFOUND_ERROR, "ERROR", id);
        } catch (Throwable e) {
            return getResponseEntity(log, e, ResponseEnumCode.SELECT_ERROR, "ERROR", id);
        }
    }

    @GetMapping("")
    public ResponseEntity<ResponseDto> findByNameContains(@RequestParam String name, Pageable pageable) {
        try {
            Page<GenreEntity> list = this.genreRepository.findByNameContains(name, pageable);
            return getResponseEntity(ResponseEnumCode.SUCCESS, "OK", list);
        } catch (MyRequestException e) {
            return getResponseEntity(log, e, ResponseEnumCode.REQUEST_ERROR, "ERROR", null);
        } catch (Throwable e) {
            log.error(e.toString());
            return getResponseEntity(log, e, ResponseEnumCode.SELECT_ERROR, "ERROR", null);
        }
    }
}
