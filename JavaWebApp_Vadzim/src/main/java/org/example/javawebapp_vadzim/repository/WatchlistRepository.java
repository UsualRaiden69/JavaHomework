package org.example.javawebapp_vadzim.repository;

import org.example.javawebapp_vadzim.model.Watchlist;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WatchlistRepository {

    private final List<Watchlist> watchlists = new ArrayList<>();

    public List<Watchlist> findAll() {
        return watchlists;
    }

    public Watchlist findById(Long id) {
        return watchlists.stream()
                .filter(w -> w.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Watchlist save(Watchlist watchlist) {
        watchlists.add(watchlist);
        return watchlist;
    }

    public Watchlist update(Long id, Watchlist updated) {

        Watchlist watchlist = findById(id);

        if (watchlist != null) {
            watchlist.setUsername(updated.getUsername());
            watchlist.setGameIds(updated.getGameIds());
        }

        return watchlist;
    }

    public void delete(Long id) {
        watchlists.removeIf(w -> w.getId().equals(id));
    }
}