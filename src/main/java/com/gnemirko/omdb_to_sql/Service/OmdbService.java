package com.gnemirko.omdb_to_sql.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gnemirko.omdb_to_sql.Entity.Movie;
import com.gnemirko.omdb_to_sql.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@RequiredArgsConstructor
public class OmdbService {
    private final MovieRepository movieRepository;

    @Value("$3131d1a6")
    private String apiKey;

    public Movie fetchAndSaveMovie(String title) throws Exception {
        String url = "http://www.omdbapi.com/?t=" + title + "&apikey=" + apiKey;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(response.body());

        Movie movie = new Movie();
        movie.setTitle(json.get("Title").asText());
        movie.setYear(json.get("Year").asText());
        movie.setDirector(json.get("Director").asText());
        movie.setImdbRating(json.get("imdbRating").asText());

        return movieRepository.save(movie);
    }
}
