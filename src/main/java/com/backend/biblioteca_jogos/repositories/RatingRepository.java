package com.backend.biblioteca_jogos.repositories;

import com.backend.biblioteca_jogos.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {}
