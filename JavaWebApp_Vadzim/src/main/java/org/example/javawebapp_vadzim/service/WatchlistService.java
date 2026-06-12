package org.example.javawebapp_vadzim.service;

import org.example.javawebapp_vadzim.model.Watchlist;
import org.example.javawebapp_vadzim.repository.WatchlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistService {

    private final WatchlistRepository repository;

    public WatchlistService(WatchlistRepository repository) {
        this.repository = repository;
    }

    public List<Watchlist> getAllWatchlists() {
        return repository.findAll();
    }

    public Watchlist getWatchlist(Long id) {
        return repository.findById(id);
    }

    public Watchlist createWatchlist(Watchlist watchlist) {
        return repository.save(watchlist);
    }

    public Watchlist updateWatchlist(Long id,
                                     Watchlist watchlist) {
        return repository.update(id, watchlist);
    }

    public void deleteWatchlist(Long id) {
        repository.delete(id);
    }

    public Watchlist addGame(Long watchlistId,
                             Long gameId) {

        Watchlist watchlist =
                repository.findById(watchlistId);

        if (watchlist != null) {
            watchlist.getGameIds().add(gameId);
        }

        return watchlist;
    }
}