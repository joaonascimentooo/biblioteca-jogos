package com.backend.biblioteca_jogos.controllers;

import com.backend.biblioteca_jogos.dto.PlatformRequest;
import com.backend.biblioteca_jogos.dto.PlatformResponse;
import com.backend.biblioteca_jogos.services.PlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platforms")
@RequiredArgsConstructor
public class PlatformController {

    private final PlatformService service;

    @GetMapping
    public ResponseEntity<List<PlatformResponse>> listar() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @PostMapping
    public ResponseEntity<PlatformResponse> criar(@RequestBody PlatformRequest request) {
        PlatformResponse response = service.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
