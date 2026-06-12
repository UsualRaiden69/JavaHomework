package org.example.javawebapp_vadzim.repository;

import org.example.javawebapp_vadzim.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {

    private final List<Category> categories = new ArrayList<>();

    public List<Category> findAll() {
        return categories;
    }

    public Category findById(Long id) {
        return categories.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Category save(Category category) {
        categories.add(category);
        return category;
    }

    public Category update(Long id, Category updated) {

        Category category = findById(id);

        if (category != null) {
            category.setName(updated.getName());
        }

        return category;
    }

    public void delete(Long id) {
        categories.removeIf(c -> c.getId().equals(id));
    }
}