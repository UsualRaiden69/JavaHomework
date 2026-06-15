package org.example.javawebapp_vadzim.service;

import org.example.javawebapp_vadzim.exception.ResourceNotFoundException;
import org.example.javawebapp_vadzim.model.Category;
import org.example.javawebapp_vadzim.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    private static final Logger logger =
            LoggerFactory.getLogger(CategoryService.class);

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getAllCategories() {
        logger.info("Getting all categories");
        return repository.findAll();
    }

    public Category getCategory(Long id) {

        logger.debug("Searching category {}", id);

        Category category = repository.findById(id);

        if (category == null) {
            logger.warn("Category not found {}", id);
            throw new ResourceNotFoundException("Category not found: " + id);
        }

        return category;
    }

    public Category updateCategory(Long id, Category category) {
        return category;
    }

    public Category createCategory(Category category) {
        return category;
    }

    public void deleteCategory(Long id) {

    }
}