package org.example.javawebapp_vadzim.repository;

import org.example.javawebapp_vadzim.model.Game;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GameRepository {

    private final List<Game> games = new ArrayList<>();

    public List<Game> findAll() {
        return games;
    }

    public Game findById(Long id) {
        return games.stream()
                .filter(g -> g.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Game save(Game game) {
        games.add(game);
        return game;
    }

    public Game update(Long id, Game updatedGame) {

        Game game = findById(id);

        if (game != null) {
            game.setSteamId(updatedGame.getSteamId());
            game.setTitle(updatedGame.getTitle());
            game.setPrice(updatedGame.getPrice());
            game.setCurrency(updatedGame.getCurrency());
            game.setCategoryId(updatedGame.getCategoryId());
        }

        return game;
    }

    public void delete(Long id) {
        games.removeIf(g -> g.getId().equals(id));
    }
}
