package com.backend.biblioteca_jogos.repositories;

import com.backend.biblioteca_jogos.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findByTitleContaining(String title);
}