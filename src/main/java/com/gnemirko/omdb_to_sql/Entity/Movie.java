package com.gnemirko.omdb_to_sql.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String year;
    private String director;
    private String imdbRating;

    private String plot;
    private String genre;
    private String actors;
}