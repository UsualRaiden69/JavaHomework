package org.example.javawebapp_vadzim.service;

import org.example.javawebapp_vadzim.dto.WatchlistDto;
import org.example.javawebapp_vadzim.exception.ResourceNotFoundException;
import org.example.javawebapp_vadzim.mapper.WatchlistMapper;
import org.example.javawebapp_vadzim.model.Watchlist;
import org.example.javawebapp_vadzim.repository.WatchlistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WatchlistService {

    private final WatchlistRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(WatchlistService.class);

    public WatchlistService(WatchlistRepository repository) {
        this.repository = repository;
    }

    public List<WatchlistDto> getAllWatchlists() {
        logger.info("Getting all watchlists");

        return repository.findAll()
                .stream()
                .map(WatchlistMapper::toDto)
                .collect(Collectors.toList());
    }

    public WatchlistDto getWatchlist(Long id) {
        Optional<Watchlist> watchlist = repository.findById(id);

        if (watchlist.isEmpty()) {
            throw new ResourceNotFoundException("Watchlist not found: " + id);
        }

        return WatchlistMapper.toDto(watchlist.orElse(null));
    }

    public WatchlistDto createWatchlist(WatchlistDto dto) {
        Watchlist watchlist = WatchlistMapper.toEntity(dto);
        return WatchlistMapper.toDto(repository.save(watchlist));
    }

    public WatchlistDto updateWatchlist(Long id, WatchlistDto dto) {
        Optional<Watchlist> existing = repository.findById(id);

        if (existing.isEmpty()) {
            throw new ResourceNotFoundException("Watchlist not found: " + id);
        }

        existing.get().setUsername(dto.getUsername());
        existing.get().setGameIds(dto.getGameIds());

        return WatchlistMapper.toDto(existing.orElse(null));
    }

    public void deleteWatchlist(Long id) {
        repository.deleteById(id);
    }

    public WatchlistDto addGame(Long watchlistId, Long gameId) {
        Optional<Watchlist> watchlist = repository.findById(watchlistId);

        if (watchlist.isEmpty()) {
            throw new ResourceNotFoundException("Watchlist not found: " + watchlistId);
        }

        watchlist.get().getGameIds().add(gameId);

        return WatchlistMapper.toDto(watchlist.orElse(null));
    }
}