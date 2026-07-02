package org.example.javawebapp_vadzim.controller;

import org.example.javawebapp_vadzim.dto.GameDto;
import org.example.javawebapp_vadzim.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameDto> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public GameDto getGame(@PathVariable Long id) {
        return gameService.getGame(id);
    }

    @PostMapping
    public GameDto createGame(@RequestBody GameDto dto) {
        return gameService.createGame(dto);
    }

    @PutMapping("/{id}")
    public GameDto updateGame(@PathVariable Long id,
                              @RequestBody GameDto dto) {
        return gameService.updateGame(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
    }
}