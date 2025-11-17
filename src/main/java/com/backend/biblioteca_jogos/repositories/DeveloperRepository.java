package com.backend.biblioteca_jogos.repositories;

import com.backend.biblioteca_jogos.models.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {}
