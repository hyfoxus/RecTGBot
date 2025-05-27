package com.gnemirko.omdb_to_sql.Controller;

import com.gnemirko.omdb_to_sql.Service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bot")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping("/recommend")
    public String recommend(@RequestParam String telegramId) {
        return recommendationService.recommendForTelegramUser(telegramId);
    }
}