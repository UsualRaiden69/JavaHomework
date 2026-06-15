package org.example.javawebapp_vadzim.service;

import org.example.javawebapp_vadzim.exception.ResourceNotFoundException;
import org.example.javawebapp_vadzim.model.Game;
import org.example.javawebapp_vadzim.repository.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository repository;

    private static final Logger logger =
            LoggerFactory.getLogger(GameService.class);

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public List<Game> getAllGames() {
        logger.info("Getting all games");
        return repository.findAll();
    }

    public Game getGame(Long id) {

        logger.debug("Searching game with id {}", id);

        Game game = repository.findById(id);

        if (game == null) {
            logger.warn("Game not found with id {}", id);
            throw new ResourceNotFoundException("Game not found: " + id);
        }

        return game;
    }

    public Game createGame(Game game) {
        logger.info("Creating game: {}", game.getTitle());
        return repository.save(game);
    }

    public Game updateGame(Long id, Game updated) {

        logger.info("Updating game with id {}", id);

        Game game = getGame(id);

        game.setSteamId(updated.getSteamId());
        game.setTitle(updated.getTitle());
        game.setPrice(updated.getPrice());
        game.setCurrency(updated.getCurrency());
        game.setCategoryId(updated.getCategoryId());

        return game;
    }

    public void deleteGame(Long id) {
        logger.info("Deleting game with id {}", id);
        repository.delete(id);
    }
}