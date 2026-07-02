package org.example.javawebapp_vadzim.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "watchlists")
public class Watchlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @ElementCollection
    private List<Long> gameIds = new ArrayList<>();

    public Watchlist() {
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