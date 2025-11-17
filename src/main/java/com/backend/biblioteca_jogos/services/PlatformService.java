package com.backend.biblioteca_jogos.services;

import com.backend.biblioteca_jogos.dto.PlatformRequest;
import com.backend.biblioteca_jogos.dto.PlatformResponse;
import com.backend.biblioteca_jogos.models.Platform;
import com.backend.biblioteca_jogos.repositories.PlatformRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlatformService {

    private final PlatformRepository repository;

    public List<PlatformResponse> listarTodas() {
        return repository.findAll().stream()
                .map(plat -> new PlatformResponse(plat.getId(), plat.getName()))
                .collect(Collectors.toList());
    }

    @Transactional
    public PlatformResponse criar(PlatformRequest request) {
        Platform platform = new Platform();
        platform.setName(request.getName());

        Platform salvo = repository.save(platform);

        return new PlatformResponse(salvo.getId(), salvo.getName());
    }
}