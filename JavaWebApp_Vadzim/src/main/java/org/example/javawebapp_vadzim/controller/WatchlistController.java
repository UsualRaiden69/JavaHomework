package org.example.javawebapp_vadzim.controller;

import org.example.javawebapp_vadzim.model.Watchlist;
import org.springframework.web.bind.annotation.*;

import org.example.javawebapp_vadzim.service.WatchlistService;

import java.util.List;

@RestController
@RequestMapping("/api/watchlists")
public class WatchlistController {

    private final WatchlistService watchlistService;

    public WatchlistController(WatchlistService watchlistService) {
        this.watchlistService = watchlistService;
    }

    @GetMapping
    public List<Watchlist> getAllWatchlists() {
        return watchlistService.getAllWatchlists();
    }

    @GetMapping("/{id}")
    public Watchlist getWatchlist(@PathVariable Long id) {
        return watchlistService.getWatchlist(id);
    }

    @PostMapping
    public Watchlist createWatchlist(@RequestBody Watchlist watchlist) {
        return watchlistService.createWatchlist(watchlist);
    }

    @PutMapping("/{id}")
    public Watchlist updateWatchlist(@PathVariable Long id,
                                     @RequestBody Watchlist watchlist) {
        return watchlistService.updateWatchlist(id, watchlist);
    }

    @DeleteMapping("/{id}")
    public void deleteWatchlist(@PathVariable Long id) {
        watchlistService.deleteWatchlist(id);
    }

    @PostMapping("/{watchlistId}/games/{gameId}")
    public Watchlist addGame(@PathVariable Long watchlistId,
                             @PathVariable Long gameId) {
        return watchlistService.addGame(watchlistId, gameId);
    }
}