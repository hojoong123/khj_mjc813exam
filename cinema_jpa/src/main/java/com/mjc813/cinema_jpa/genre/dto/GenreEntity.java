package com.mjc813.cinema_jpa.genre.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Generated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "GenreEntity")
@Table(name = "genre2_tbl")
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @Column(name = "nm", length = 20, unique = true, nullable = false)
    private String name;
}
