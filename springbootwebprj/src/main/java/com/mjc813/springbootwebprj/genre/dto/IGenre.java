package com.mjc813.springbootwebprj.genre.dto;

public interface IGenre {
    Long getId();
    void setId(Long id);

    String getName();
    void setName(String name);

    default void copyMembers(IGenre isrc) {
        if ( isrc == null ) {
            return;
        }
        this.setId( isrc.getId() );
        this.setName( isrc.getName() );
    }

    default void copyMembersNotNull(IGenre isrc) {
        if ( isrc == null ) {
            return;
        }
        if ( isrc.getId() != null ) {
            this.setId(isrc.getId());
        }
        if ( isrc.getName() != null ) {
            this.setName(isrc.getName());
        }
    }
}
