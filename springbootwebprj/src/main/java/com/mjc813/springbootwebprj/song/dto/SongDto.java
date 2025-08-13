package com.mjc813.springbootwebprj.song.dto;

import com.mjc813.springbootwebprj.genre.dto.GenreDto;
import com.mjc813.springbootwebprj.genre.dto.IGenre;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SongDto implements ISong {
    private Long id;
    private String title;
    private Long genreId;
    private GenreDto genreDto;
    private String composer;
    private String artist;
    private LocalDate releaseDate;
    private String genreName;

    @Override
    public IGenre getGenre() {
        return this.getGenreDto();
    }

    @Override
    public void setGenre(IGenre genre) {
        this.genreDto.setId(genre.getId());
        this.genreDto.setName(genre.getName());
    }

    @Override
    public Long getGenreId() {
        if ( this.genreDto == null ) {
            this.genreDto = new GenreDto();
        }
        return this.genreDto.getId();
    }

    @Override
    public void setGenreId(Long genreId) {
        if ( this.genreDto == null ) {
            this.genreDto = new GenreDto();
        }
        this.genreDto.setId(genreId);
        this.genreId = genreId;
    }
}
