package com.mjc813.springbootwebprj.song.dto;

import com.mjc813.springbootwebprj.genre.dto.GenreDto;
import com.mjc813.springbootwebprj.genre.dto.GenreEntity;
import com.mjc813.springbootwebprj.genre.dto.IGenre;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "song_tb")
public class SongEntity implements ISong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String title;

    @Transient  // Jpa 에서 DDL 언어에서 column 을 만들지 않는다.
    private Long genreId;

    @Transient  // Jpa 에서 DDL 언어에서 column 을 만들지 않는다.
    private String genreName;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private GenreEntity genre;

    @Column(nullable = false, length = 50)
    private String composer;

    @Column(nullable = false, length = 50)
    private String artist;

    private LocalDate releaseDate;

    @Override
    public IGenre getGenre() {
        return this.genre;
    }

    @Override
    public void setGenre(IGenre genre) {
        this.genre.setId(genre.getId());
        this.genre.setName(genre.getName());
    }

    @Override
    public Long getGenreId() {
        if ( this.genre == null ) {
            this.genre = new GenreEntity();
        }
        return this.genre.getId();
    }

    @Override
    public void setGenreId(Long genreId) {
        if ( this.genre == null ) {
            this.genre = new GenreEntity();
        }
        this.genre.setId(genreId);
        this.genreId = genreId;
    }
}
