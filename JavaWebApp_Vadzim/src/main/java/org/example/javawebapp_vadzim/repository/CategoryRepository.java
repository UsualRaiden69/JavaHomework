package org.example.javawebapp_vadzim.repository;

import org.example.javawebapp_vadzim.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}