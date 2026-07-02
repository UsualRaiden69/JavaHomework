package org.example.javawebapp_vadzim.controller;

import org.example.javawebapp_vadzim.dto.WatchlistDto;
import org.example.javawebapp_vadzim.service.WatchlistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/watchlists")
public class WatchlistController {

    private final WatchlistService watchlistService;

    public WatchlistController(WatchlistService watchlistService) {
        this.watchlistService = watchlistService;
    }

    @GetMapping
    public List<WatchlistDto> getAllWatchlists() {
        return watchlistService.getAllWatchlists();
    }

    @GetMapping("/{id}")
    public WatchlistDto getWatchlist(@PathVariable Long id) {
        return watchlistService.getWatchlist(id);
    }

    @PostMapping
    public WatchlistDto createWatchlist(@RequestBody WatchlistDto dto) {
        return watchlistService.createWatchlist(dto);
    }

    @PutMapping("/{id}")
    public WatchlistDto updateWatchlist(@PathVariable Long id,
                                        @RequestBody WatchlistDto dto) {
        return watchlistService.updateWatchlist(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteWatchlist(@PathVariable Long id) {
        watchlistService.deleteWatchlist(id);
    }

    @PostMapping("/{watchlistId}/games/{gameId}")
    public WatchlistDto addGame(@PathVariable Long watchlistId,
                                @PathVariable Long gameId) {
        return watchlistService.addGame(watchlistId, gameId);
    }
}