package org.example.javawebapp_vadzim.service;

import org.example.javawebapp_vadzim.model.Category;
import org.example.javawebapp_vadzim.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    public Category getCategory(Long id) {
        return repository.findById(id);
    }

    public Category createCategory(Category category) {
        return repository.save(category);
    }

    public Category updateCategory(Long id, Category category) {
        return repository.update(id, category);
    }

    public void deleteCategory(Long id) {
        repository.delete(id);
    }
}
