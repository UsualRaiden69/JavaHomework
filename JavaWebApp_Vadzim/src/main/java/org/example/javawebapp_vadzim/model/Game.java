package org.example.javawebapp_vadzim.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String steamId;
    private String title;
    private BigDecimal price;
    private String currency;
    private Long categoryId;

    public Game() {
    }

    public Game(Long id,
                String steamId,
                String title,
                BigDecimal price,
                String currency,
                Long categoryId) {
        this.id = id;
        this.steamId = steamId;
        this.title = title;
        this.price = price;
        this.currency = currency;
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public String getSteamId() {
        return steamId;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSteamId(String steamId) {
        this.steamId = steamId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}