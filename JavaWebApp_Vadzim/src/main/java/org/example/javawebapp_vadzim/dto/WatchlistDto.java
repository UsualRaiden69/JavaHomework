package org.example.javawebapp_vadzim.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class WatchlistDto {

    private Long id;

    @NotBlank
    private String username;

    private List<Long> gameIds;

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