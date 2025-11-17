package com.backend.biblioteca_jogos.repositories;

import com.backend.biblioteca_jogos.models.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long> {}
