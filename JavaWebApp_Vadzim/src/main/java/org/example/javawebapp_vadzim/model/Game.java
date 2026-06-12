package org.example.javawebapp_vadzim.model;

public class Game {

    private Long id;
    private String steamId;
    private String title;
    private Double price;
    private String currency;
    private Long categoryId;

    public Game() {
    }

    public Game(Long id, String steamId, String title,
                Double price, String currency, Long categoryId) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getSteamId() {
        return steamId;
    }

    public void setSteamId(String steamId) {
        this.steamId = steamId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}