package com.gnemirko.omdb_to_sql.Service;


import com.gnemirko.omdb_to_sql.Entity.User;
import com.gnemirko.omdb_to_sql.Entity.WatchedMovie;
import com.gnemirko.omdb_to_sql.Repository.UserRepository;
import com.gnemirko.omdb_to_sql.Repository.WatchedMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private final UserRepository userRepository;
    private final WatchedMovieRepository watchedRepo;
    private final MovieAiService movieAiService;

    public String recommendForTelegramUser(String telegramId) {
        User user = userRepository.findByTelegramId(telegramId);
        List<WatchedMovie> history = watchedRepo.findByUserAndLikedTrue(user);
        return movieAiService.generateRecommendations(user, history);
    }
}