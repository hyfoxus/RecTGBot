package com.gnemirko.omdb_to_sql.Repository;

import com.gnemirko.omdb_to_sql.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface MovieRepository extends JpaRepository<Movie, Long> {}
