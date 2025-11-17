package com.backend.biblioteca_jogos.services;

import com.backend.biblioteca_jogos.dto.GameRequest;
import com.backend.biblioteca_jogos.dto.GameResponse;
import com.backend.biblioteca_jogos.models.Category;
import com.backend.biblioteca_jogos.models.Developer;
import com.backend.biblioteca_jogos.models.Game;
import com.backend.biblioteca_jogos.models.Platform;
import com.backend.biblioteca_jogos.models.Publisher;
import com.backend.biblioteca_jogos.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final CategoryRepository categoryRepository;
    private final PlatformRepository platformRepository;
    private final DeveloperRepository developerRepository;
    private final PublisherRepository publisherRepository;

    public List<GameResponse> listarTodos() {
        return gameRepository.findAll().stream()
                .map(GameResponse::new)
                .collect(Collectors.toList());
    }

    public GameResponse buscarPorId(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado com ID: " + id));
        return new GameResponse(game);
    }

    @Transactional
    public GameResponse criarGame(GameRequest request) {
        Game game = new Game();
        aplicarDados(game, request);
        Game gameSalvo = gameRepository.save(game);
        return new GameResponse(gameSalvo);
    }

    @Transactional
    public GameResponse atualizarGame(Long id, GameRequest request) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado com ID: " + id));

        aplicarDados(game, request);

        return new GameResponse(gameRepository.save(game));
    }

    @Transactional
    public GameResponse atualizarParcial(Long id, GameRequest request) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado com ID: " + id));

        Optional.ofNullable(request.getTitle()).ifPresent(game::setTitle);
        Optional.ofNullable(request.getDescription()).ifPresent(game::setDescription);
        Optional.ofNullable(request.getPrice()).ifPresent(game::setPrice);
        Optional.ofNullable(request.getStock()).ifPresent(game::setStock);
        Optional.ofNullable(request.getCoverUrl()).ifPresent(game::setCoverUrl);
        Optional.ofNullable(request.getReleaseDate()).ifPresent(game::setReleaseDate);
        Optional.ofNullable(request.getAgeRating()).ifPresent(game::setAgeRating);

        Optional.ofNullable(request.getCategoryIds()).ifPresent(ids -> {
            if (!ids.isEmpty()) {
                List<Category> categorias = categoryRepository.findAllById(ids);
                game.setCategories(new HashSet<>(categorias));
            }
        });

        Optional.ofNullable(request.getPlatformIds()).ifPresent(ids -> {
            List<Platform> platforms = platformRepository.findAllById(ids);
            game.setPlatforms(new HashSet<>(platforms));
        });

        Optional.ofNullable(request.getDeveloperIds()).ifPresent(ids -> {
            List<Developer> developers = developerRepository.findAllById(ids);
            game.setDevelopers(new HashSet<>(developers));
        });

        Optional.ofNullable(request.getPublisherIds()).ifPresent(ids -> {
            List<Publisher> publishers = publisherRepository.findAllById(ids);
            game.setPublishers(new HashSet<>(publishers));
        });

        return new GameResponse(gameRepository.save(game));
    }

    public void deletarGame(Long id) {
        if (!gameRepository.existsById(id)) {
            throw new RuntimeException("Jogo não encontrado para deleção.");
        }
        gameRepository.deleteById(id);
    }

    private void aplicarDados(Game game, GameRequest request) {

        game.setTitle(request.getTitle());
        game.setDescription(request.getDescription());
        game.setPrice(request.getPrice());
        game.setStock(request.getStock());
        game.setCoverUrl(request.getCoverUrl());
        game.setReleaseDate(request.getReleaseDate());
        game.setAgeRating(request.getAgeRating());

        Optional.ofNullable(request.getCategoryIds())
                .ifPresent(ids -> {
                    List<Category> categorias = categoryRepository.findAllById(ids);
                    game.setCategories(new HashSet<>(categorias));
                });

        Optional.ofNullable(request.getPlatformIds())
                .ifPresent(ids -> {
                    List<Platform> platforms = platformRepository.findAllById(ids);
                    game.setPlatforms(new HashSet<>(platforms));
                });

        Optional.ofNullable(request.getDeveloperIds())
                .ifPresent(ids -> {
                    List<Developer> developers = developerRepository.findAllById(ids);
                    game.setDevelopers(new HashSet<>(developers));
                });

        Optional.ofNullable(request.getPublisherIds())
                .ifPresent(ids -> {
                    List<Publisher> publishers = publisherRepository.findAllById(ids);
                    game.setPublishers(new HashSet<>(publishers));
                });
    }
}