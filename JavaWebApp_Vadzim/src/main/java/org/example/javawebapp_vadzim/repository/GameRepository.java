package org.example.javawebapp_vadzim.repository;

import org.example.javawebapp_vadzim.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}