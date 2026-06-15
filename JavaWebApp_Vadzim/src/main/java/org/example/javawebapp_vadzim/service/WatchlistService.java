package org.example.javawebapp_vadzim.service;

import org.example.javawebapp_vadzim.exception.ResourceNotFoundException;
import org.example.javawebapp_vadzim.model.Watchlist;
import org.example.javawebapp_vadzim.repository.WatchlistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistService {

    private final WatchlistRepository repository;

    private static final Logger logger =
            LoggerFactory.getLogger(WatchlistService.class);

    public WatchlistService(WatchlistRepository repository) {
        this.repository = repository;
    }

    public List<Watchlist> getAllWatchlists() {
        logger.info("Getting all watchlists");
        return repository.findAll();
    }

    public Watchlist getWatchlist(Long id) {
        logger.debug("Searching watchlist with id {}", id);
        Watchlist watchlist = repository.findById(id);

        if (watchlist == null) {
            logger.warn("Watchlist not found with id {}", id);
            throw new ResourceNotFoundException(
                    "Watchlist not found: " + id
            );
        }

        return watchlist;
    }

    public Watchlist createWatchlist(Watchlist watchlist) {
        logger.info("Creating watchlist for user: {}", watchlist.getUsername());
        return repository.save(watchlist);
    }

    public Watchlist updateWatchlist(Long id, Watchlist updated) {
        logger.info("Updating watchlist with id {}", id);
        Watchlist watchlist = getWatchlist(id);
        watchlist.setUsername(updated.getUsername());
        watchlist.setGameIds(updated.getGameIds());
        return watchlist;
    }
    public void deleteWatchlist(Long id) {
        logger.info("Deleting watchlist with id {}", id);
        repository.delete(id);
    }

    public Watchlist addGame(Long watchlistId, Long gameId) {
        logger.info("Adding game {} to watchlist {}", gameId, watchlistId);
        Watchlist watchlist = getWatchlist(watchlistId);
        watchlist.getGameIds().add(gameId);
        return watchlist;
    }
}