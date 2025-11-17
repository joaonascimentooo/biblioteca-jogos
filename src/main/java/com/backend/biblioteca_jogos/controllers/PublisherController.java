package com.backend.biblioteca_jogos.controllers;

import com.backend.biblioteca_jogos.dto.PublisherRequest;
import com.backend.biblioteca_jogos.dto.PublisherResponse;
import com.backend.biblioteca_jogos.services.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService service;

    @GetMapping
    public ResponseEntity<List<PublisherResponse>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<PublisherResponse> criar(@RequestBody PublisherRequest request) {
        PublisherResponse response = service.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}