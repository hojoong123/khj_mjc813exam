package com.mjc813.springbootwebprj.genre.controller;

import com.mjc813.springbootwebprj.genre.dto.GenreEntity;
import com.mjc813.springbootwebprj.genre.service.GenreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/genre")
public class GenreRestController {
    @Autowired
    private GenreRepository genreRepository;

    @PostMapping("")
    public ResponseEntity<GenreEntity> insert(@RequestBody GenreEntity entity) {
        try {
            this.genreRepository.save(entity);
            return ResponseEntity.ok().body(entity);
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(entity);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GenreEntity> update(@RequestBody GenreEntity entity) {
        try {
            this.genreRepository.save(entity);
            return ResponseEntity.ok().body(entity);
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(entity);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        try {
            this.genreRepository.deleteById(id);
            return ResponseEntity.ok().body(id);
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(id);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreEntity> findById(@PathVariable Long id) {
        try {
            Optional<GenreEntity> find = this.genreRepository.findById(id);
            if (find.isPresent()) {
                return ResponseEntity.ok().body(find.orElse(null));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("")
    public ResponseEntity<Page<GenreEntity>> findByNameContains(@RequestParam String name, Pageable pageable) {
        try {
            Page<GenreEntity> list = this.genreRepository.findByNameContains(name, pageable);
            return ResponseEntity.ok().body(list);
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(null);
        }
    }
}
