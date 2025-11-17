package com.backend.biblioteca_jogos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatformResponse {
    private Long id;
    private String name;
}