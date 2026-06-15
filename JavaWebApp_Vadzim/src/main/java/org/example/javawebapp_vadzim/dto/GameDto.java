package org.example.javawebapp_vadzim.dto;

public class GameDto {

    private Long id;
    private String title;
    private double price;
    private String currency;
    private Long categoryId;

    public GameDto() {}

    public GameDto(Long id, String title, double price, String currency, Long categoryId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.currency = currency;
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}