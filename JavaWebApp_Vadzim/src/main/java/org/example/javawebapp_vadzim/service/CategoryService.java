package org.example.javawebapp_vadzim.service;

import org.example.javawebapp_vadzim.dto.CategoryDto;
import org.example.javawebapp_vadzim.exception.ResourceNotFoundException;
import org.example.javawebapp_vadzim.mapper.CategoryMapper;
import org.example.javawebapp_vadzim.model.Category;
import org.example.javawebapp_vadzim.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<CategoryDto> getAllCategories() {
        logger.info("Getting all categories");
        return repository.findAll()
                .stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public CategoryDto getCategory(Long id) {
        logger.debug("Searching category {}", id);

        Optional<Category> category = repository.findById(id);

        if (category.isEmpty()) {
            throw new ResourceNotFoundException("Category not found: " + id);
        }

        return CategoryMapper.toDto(category.orElse(null));
    }

    public CategoryDto createCategory(CategoryDto dto) {
        Category category = CategoryMapper.toEntity(dto);
        return CategoryMapper.toDto(repository.save(category));
    }

    public CategoryDto updateCategory(Long id, CategoryDto dto) {
        Optional<Category> existing = repository.findById(id);

        if (existing.isEmpty()) {
            throw new ResourceNotFoundException("Category not found: " + id);
        }

        existing.get().setName(dto.getName());
        return CategoryMapper.toDto(existing.orElse(null));
    }

    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}