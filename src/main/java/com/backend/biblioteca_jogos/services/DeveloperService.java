package com.backend.biblioteca_jogos.services;

import com.backend.biblioteca_jogos.dto.DeveloperRequest;
import com.backend.biblioteca_jogos.dto.DeveloperResponse;
import com.backend.biblioteca_jogos.models.Developer;
import com.backend.biblioteca_jogos.repositories.DeveloperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeveloperService {

    private final DeveloperRepository repository;

    public List<DeveloperResponse> listarTodos() {
        return repository.findAll().stream()
                .map(dev -> new DeveloperResponse(dev.getId(), dev.getName()))
                .collect(Collectors.toList());
    }

    @Transactional
    public DeveloperResponse criar(DeveloperRequest request) {
        Developer developer = new Developer();
        developer.setName(request.getName());

        Developer salvo = repository.save(developer);

        return new DeveloperResponse(salvo.getId(), salvo.getName());
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}