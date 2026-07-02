package org.example.javawebapp_vadzim.mapper;

import org.example.javawebapp_vadzim.dto.WatchlistDto;
import org.example.javawebapp_vadzim.model.Watchlist;

public class WatchlistMapper {

    public static WatchlistDto toDto(Watchlist watchlist) {
        if (watchlist == null) return null;

        WatchlistDto dto = new WatchlistDto();
        dto.setId(watchlist.getId());
        dto.setUsername(watchlist.getUsername());
        dto.setGameIds(watchlist.getGameIds());
        return dto;
    }

    public static Watchlist toEntity(WatchlistDto dto) {
        if (dto == null) return null;

        Watchlist watchlist = new Watchlist();
        watchlist.setId(dto.getId());
        watchlist.setUsername(dto.getUsername());
        watchlist.setGameIds(dto.getGameIds());
        return watchlist;
    }
}