package com.gnemirko.omdb_to_sql.Service;

import com.gnemirko.omdb_to_sql.Entity.User;
import com.gnemirko.omdb_to_sql.Entity.WatchedMovie;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieAiService {

    private final ChatClient chatClient;

    public String generateDescription(String title, String plot) {
        return chatClient.prompt()
                .user("Write a fun and engaging 3-sentence description for the movie \"%s\". Plot: %s".formatted(title, plot))
                .call()
                .content();
    }

    public String generateRecommendations(User user, List<WatchedMovie> history) {
        String watchedTitles = history.stream()
                .map(w -> w.getMovie().getTitle())
                .collect(Collectors.joining(", "));

        String systemPrompt = String.format("""
        You are a movie recommendation assistant.
        The user watched and liked: %s.
        They prefer genres: %s.
        Recommend 3 titles they are likely to enjoy.
        Include a short reason for each.
        """, watchedTitles, user.getPreferredGenres());

        return chatClient.prompt().user(systemPrompt).call().content();
    }
}
