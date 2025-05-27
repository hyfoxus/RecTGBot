package com.gnemirko.omdb_to_sql.Controller;

import com.gnemirko.omdb_to_sql.Entity.Movie;
import com.gnemirko.omdb_to_sql.Service.OmdbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movies")
public class MovieController {

    private final OmdbService omdbService;

    @PostMapping
    public Movie fetchAndSave(@RequestParam String title) throws Exception {
        return omdbService.fetchAndSaveMovie(title);
    }
}
