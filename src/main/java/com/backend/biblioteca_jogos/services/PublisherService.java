package com.backend.biblioteca_jogos.services;

import com.backend.biblioteca_jogos.dto.PublisherRequest;
import com.backend.biblioteca_jogos.dto.PublisherResponse;
import com.backend.biblioteca_jogos.models.Publisher;
import com.backend.biblioteca_jogos.repositories.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository repository;

    public List<PublisherResponse> listarTodos() {
        return repository.findAll().stream()
                .map(pub -> new PublisherResponse(pub.getId(), pub.getName()))
                .collect(Collectors.toList());
    }

    @Transactional
    public PublisherResponse criar(PublisherRequest request) {
        Publisher publisher = new Publisher();
        publisher.setName(request.getName());

        Publisher salvo = repository.save(publisher);

        return new PublisherResponse(salvo.getId(), salvo.getName());
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}