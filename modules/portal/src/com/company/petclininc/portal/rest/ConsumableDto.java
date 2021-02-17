package com.company.petclininc.portal.rest;

import com.company.petclininc.entity.Consumable;

import java.math.BigDecimal;
import java.util.UUID;

public class ConsumableDto {

    private UUID id;

    private String title;

    private BigDecimal price;

    public ConsumableDto() {
    }

    public ConsumableDto(Consumable c) {
        this.id = c.getId();
        this.title = c.getTitle();
        this.price = c.getPrice();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}