package com.mjc813.springbootwebprj.song.dto;

import com.mjc813.springbootwebprj.genre.dto.GenreDto;
import com.mjc813.springbootwebprj.genre.dto.IGenre;

import java.time.LocalDate;

public interface ISong {
    Long getId();
    String getTitle();
    Long getGenreId();
    IGenre getGenre();
    String getComposer();
    String getArtist();
    LocalDate getReleaseDate();
    String getGenreName();

    void setId(final Long id);
    void setTitle(final String title);
    void setGenreId(final Long genreId);
    void setGenre(final IGenre genre);
    void setComposer(final String composer);
    void setArtist(final String artist);
    void setReleaseDate(final LocalDate releaseDate);
    void setGenreName(String genreName);

    default void copyMembers(ISong isrc) {
        if ( isrc == null ) {
            return;
        }
        this.setId(isrc.getId());
        this.setTitle(isrc.getTitle());
        this.setGenreId(isrc.getGenreId());
        if( this.getGenre() == null ) {
            this.setGenre(new GenreDto());
        }
        this.getGenre().copyMembers(isrc.getGenre());
        //this.getGenre().setId(isrc.getGenre().getId());
        //this.getGenre().setName(isrc.getGenre().getName());
        this.setComposer(isrc.getComposer());
        this.setArtist(isrc.getArtist());
        this.setReleaseDate(isrc.getReleaseDate());
    }

    default void copyMembersNotNull(ISong isrc) {
        if ( isrc == null ) {
            return;
        }
        if ( isrc.getId() != null ) {
            this.setId(isrc.getId());
        }
        if ( isrc.getTitle() != null ) {
            this.setTitle(isrc.getTitle());
        }
        if ( isrc.getGenreId() != null ) {
            this.setGenreId(isrc.getGenreId());
        }
        if ( this.getGenre() == null ) {
            this.setGenre( new GenreDto() );
        }
        this.getGenre().copyMembersNotNull(isrc.getGenre());

        if ( isrc.getComposer() != null ) {
            this.setComposer(isrc.getComposer());
        }
        if ( isrc.getArtist() != null ) {
            this.setArtist(isrc.getArtist());
        }
        if ( isrc.getReleaseDate() != null ) {
            this.setReleaseDate(isrc.getReleaseDate());
        }
    }
}
