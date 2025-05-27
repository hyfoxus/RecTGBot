package com.gnemirko.omdb_to_sql.Repository;

import com.gnemirko.omdb_to_sql.Entity.User;
import com.gnemirko.omdb_to_sql.Entity.WatchedMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchedMovieRepository  extends JpaRepository<WatchedMovie, Long> {
    List<WatchedMovie> findByUserAndLikedTrue(User user);
}

