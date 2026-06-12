package org.example.javawebapp_vadzim.model;

import java.util.ArrayList;
import java.util.List;

public class Watchlist {

    private Long id;
    private String username;
    private List<Long> gameIds;

    public Watchlist() {
        this.gameIds = new ArrayList<>();
    }

    public Watchlist(Long id, String username) {
        this.id = id;
        this.username = username;
        this.gameIds = new ArrayList<>();
    }

    public Watchlist(Long id,
                     String username,
                     List<Long> gameIds) {
        this.id = id;
        this.username = username;
        this.gameIds = gameIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Long> getGameIds() {
        return gameIds;
    }

    public void setGameIds(List<Long> gameIds) {
        this.gameIds = gameIds;
    }
}