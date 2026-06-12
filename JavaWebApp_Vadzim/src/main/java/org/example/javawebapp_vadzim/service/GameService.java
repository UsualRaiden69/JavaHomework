package org.example.javawebapp_vadzim.service;

import org.example.javawebapp_vadzim.model.Game;
import org.example.javawebapp_vadzim.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public List<Game> getAllGames() {
        return repository.findAll();
    }

    public Game getGame(Long id) {
        return repository.findById(id);
    }

    public Game createGame(Game game) {
        return repository.save(game);
    }

    public Game updateGame(Long id, Game game) {
        return repository.update(id, game);
    }

    public void deleteGame(Long id) {
        repository.delete(id);
    }

    public List<Game> searchByTitle(String title) {
        return repository.findAll()
                .stream()
                .filter(g -> g.getTitle()
                        .toLowerCase()
                        .contains(title.toLowerCase()))
                .toList();
    }
}