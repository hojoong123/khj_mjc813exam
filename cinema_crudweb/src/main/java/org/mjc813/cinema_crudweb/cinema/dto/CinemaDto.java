package org.mjc813.cinema_crudweb.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CinemaDto {
    private Long id;
    private String name;
    private Long genreId;
    private String playTime;
    private String casts;
    private String description;
    private Integer restrictAge;
}
