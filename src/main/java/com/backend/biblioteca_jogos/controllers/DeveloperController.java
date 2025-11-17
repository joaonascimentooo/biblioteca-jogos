package com.backend.biblioteca_jogos.controllers;

import com.backend.biblioteca_jogos.dto.DeveloperRequest;
import com.backend.biblioteca_jogos.dto.DeveloperResponse;
import com.backend.biblioteca_jogos.services.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/developers")
@RequiredArgsConstructor
public class DeveloperController {

    private final DeveloperService service;

    @GetMapping
    public ResponseEntity<List<DeveloperResponse>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<DeveloperResponse> criar(@RequestBody DeveloperRequest request) {
        DeveloperResponse response = service.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}