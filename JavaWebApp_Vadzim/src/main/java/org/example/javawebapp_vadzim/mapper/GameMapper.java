package org.example.javawebapp_vadzim.mapper;

import org.example.javawebapp_vadzim.dto.GameDto;
import org.example.javawebapp_vadzim.model.Game;

public class GameMapper {

    public static GameDto toDto(Game game) {
        if (game == null) return null;

        GameDto dto = new GameDto();
        dto.setId(game.getId());
        dto.setSteamId(game.getSteamId());
        dto.setTitle(game.getTitle());
        dto.setPrice(game.getPrice());
        dto.setCurrency(game.getCurrency());
        dto.setCategoryId(game.getCategoryId());
        return dto;
    }

    public static Game toEntity(GameDto dto) {
        if (dto == null) return null;

        Game game = new Game();
        game.setId(dto.getId());
        game.setSteamId(dto.getSteamId());
        game.setTitle(dto.getTitle());
        game.setPrice(dto.getPrice());
        game.setCurrency(dto.getCurrency());
        game.setCategoryId(dto.getCategoryId());
        return game;
    }
}