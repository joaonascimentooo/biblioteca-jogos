package com.backend.biblioteca_jogos.repositories;

import com.backend.biblioteca_jogos.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {}