package com.backend.biblioteca_jogos.controllers;

import com.backend.biblioteca_jogos.dto.CategoryRequest;
import com.backend.biblioteca_jogos.dto.CategoryResponse;
import com.backend.biblioteca_jogos.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> listar() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> criar(@RequestBody CategoryRequest request) {
        CategoryResponse response = service.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}