package com.backend.biblioteca_jogos.controllers;

import com.backend.biblioteca_jogos.dto.GameRequest;
import com.backend.biblioteca_jogos.dto.GameResponse;
import com.backend.biblioteca_jogos.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping("/{id}")
    public ResponseEntity<GameResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(gameService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameResponse> atualizar(@PathVariable Long id, @RequestBody GameRequest request) {
        return ResponseEntity.ok(gameService.atualizarGame(id, request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GameResponse> atualizarParcial(@PathVariable Long id, @RequestBody GameRequest request) {
        return ResponseEntity.ok(gameService.atualizarParcial(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        gameService.deletarGame(id);
        return ResponseEntity.noContent().build();
    }
}