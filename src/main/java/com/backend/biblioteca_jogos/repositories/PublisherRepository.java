package com.backend.biblioteca_jogos.repositories;

import com.backend.biblioteca_jogos.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {}
