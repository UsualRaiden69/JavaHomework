package org.example.javawebapp_vadzim.dto;

import java.util.List;

public class WatchlistDto {

    private Long id;
    private String username;
    private List<Long> gameIds;

    public WatchlistDto() {}

    public WatchlistDto(Long id, String username, List<Long> gameIds) {
        this.id = id;
        this.username = username;
        this.gameIds = gameIds;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public List<Long> getGameIds() {
        return gameIds;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setGameIds(List<Long> gameIds) {
        this.gameIds = gameIds;
    }
}