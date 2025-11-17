package com.backend.biblioteca_jogos.dto;

import com.backend.biblioteca_jogos.models.Game;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class GameResponse {
    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private String coverUrl;

    private Set<String> categories;
    private Set<String> platforms;
    private Set<String> developers;
    private Set<String> publishers;

    public GameResponse(Game game) {
        this.id = game.getId();
        this.title = game.getTitle();
        this.description = game.getDescription();
        this.price = game.getPrice();
        this.coverUrl = game.getCoverUrl();

        this.categories = game.getCategories().stream()
                .map(c -> c.getName()).collect(Collectors.toSet());

        this.platforms = game.getPlatforms().stream()
                .map(p -> p.getName()).collect(Collectors.toSet());

        this.developers = game.getDevelopers().stream()
                .map(d -> d.getName()).collect(Collectors.toSet());

        this.publishers = game.getPublishers().stream()
                .map(p -> p.getName()).collect(Collectors.toSet());
    }
}
