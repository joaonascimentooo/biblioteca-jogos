package com.backend.biblioteca_jogos.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
public class GameRequest {
    private String title;
    private String description;
    private LocalDate releaseDate;
    private String ageRating;
    private BigDecimal price;
    private Integer stock;
    private String coverUrl;

    private Set<Long> categoryIds;
    private Set<Long> platformIds;
    private Set<Long> developerIds;
    private Set<Long> publisherIds;
}
