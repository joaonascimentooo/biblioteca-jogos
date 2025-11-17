package com.backend.biblioteca_jogos.services;

import com.backend.biblioteca_jogos.dto.CategoryRequest;
import com.backend.biblioteca_jogos.dto.CategoryResponse;
import com.backend.biblioteca_jogos.models.Category;
import com.backend.biblioteca_jogos.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public List<CategoryResponse> listarTodas() {
        return repository.findAll().stream()
                .map(cat -> new CategoryResponse(
                        cat.getId(),
                        cat.getName(),
                        cat.getDescription()))
                .collect(Collectors.toList());
    }


    @Transactional
    public CategoryResponse criar(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());

        Category salvo = repository.save(category);

        return new CategoryResponse(salvo.getId(), salvo.getName(), salvo.getDescription());
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}