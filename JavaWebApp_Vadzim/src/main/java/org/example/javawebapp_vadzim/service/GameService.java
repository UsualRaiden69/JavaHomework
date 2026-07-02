package org.example.javawebapp_vadzim.service;

import org.example.javawebapp_vadzim.dto.GameDto;
import org.example.javawebapp_vadzim.exception.ResourceNotFoundException;
import org.example.javawebapp_vadzim.mapper.GameMapper;
import org.example.javawebapp_vadzim.model.Game;
import org.example.javawebapp_vadzim.repository.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    private final GameRepository repository;

    private static final Logger logger =
            LoggerFactory.getLogger(GameService.class);

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public List<GameDto> getAllGames() {
        logger.info("Getting all games");

        return repository.findAll()
                .stream()
                .map(GameMapper::toDto)
                .collect(Collectors.toList());
    }

    public GameDto getGame(Long id) {

        Game game = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Game not found: " + id));

        return GameMapper.toDto(game);
    }

    public GameDto createGame(GameDto dto) {

        Game game = GameMapper.toEntity(dto);

        return GameMapper.toDto(
                repository.save(game)
        );
    }

    public GameDto updateGame(Long id, GameDto dto) {

        Game game = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Game not found: " + id));

        game.setSteamId(dto.getSteamId());
        game.setTitle(dto.getTitle());
        game.setPrice(dto.getPrice());
        game.setCurrency(dto.getCurrency());
        game.setCategoryId(dto.getCategoryId());

        return GameMapper.toDto(
                repository.save(game)
        );
    }

    public void deleteGame(Long id) {
        repository.deleteById(id);
    }
}