package com.mjc813.cinema_crudweb.cinema.controller;

import com.mjc813.cinema_crudweb.cinema.dto.CinemaDto;
import com.mjc813.cinema_crudweb.cinema.service.CinemaService;
import com.mjc813.cinema_crudweb.common.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/cinema")
public class CinemaRestController {
    @Autowired
    private CinemaService cinemaService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insertCinema(@Validated @RequestBody CinemaDto dto) {
        try {
            this.cinemaService.insertCinema(dto);
            return ResponseEntity.ok().body(
                    new ResponseDto("ok", 50010, dto)
            );
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok().body(
                    new ResponseDto("insert error", 90000, dto)
            );

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Long id) {
        try {
            CinemaDto find = this.cinemaService.findById(id);
            if ( find == null ) {
                return ResponseEntity.status(610).body(
                        new ResponseDto("not found", 49999, id)
                );
            } else {
                return ResponseEntity.ok().body(
                        new ResponseDto("suceess", 40010, find)
                );
            }
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok().body(
                    new ResponseDto("findById error", 90000, id)
            );
        }
    }
}
