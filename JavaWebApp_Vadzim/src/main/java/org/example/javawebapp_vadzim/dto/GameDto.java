package org.example.javawebapp_vadzim.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class GameDto {

    private Long id;

    @NotBlank
    private String steamId;

    @NotBlank
    private String title;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotBlank
    private String currency;

    @NotNull
    private Long categoryId;

    public Long getId() {
        return id;
    }

    public String getSteamId() {
        return steamId;
    }

    public String getTitle() {
        return title;
    }

    public @NotNull @Positive BigDecimal getPrice() {
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