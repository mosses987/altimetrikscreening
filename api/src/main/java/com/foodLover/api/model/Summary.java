package com.foodLover.api.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Summary {

    private String username;
    private Set<String> foodName = new HashSet<>();
    private Set<String> restaurantName = new HashSet<>();
    private Double totalPrice;

    public Summary(String username, Set<String> foodName, Set<String> restaurantName, Double totalPrice) {
        this.username = username;
        this.foodName = foodName;
        this.restaurantName = restaurantName;
        this.totalPrice = totalPrice;
    }

    public Summary() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getFoodName() {
        return foodName;
    }

    public void setFoodName(Set<String> foodName) {
        this.foodName = foodName;
    }

    public Set<String> getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(Set<String> restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
