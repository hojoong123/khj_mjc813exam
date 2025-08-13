package com.mjc813.springbootwebprj.genre.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenreDto implements IGenre {
    private Long id;
    /**
     * 재즈/팝/힙합/락/락발라드/해비메탈/
     */
    private String name;
}
