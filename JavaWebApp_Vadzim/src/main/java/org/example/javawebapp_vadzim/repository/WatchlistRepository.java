package org.example.javawebapp_vadzim.repository;

import org.example.javawebapp_vadzim.model.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {
}