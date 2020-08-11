package com.foodLover.api.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Integer id;

//    @Column(name = "foodname")
    private String foodname;

//    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "restid")
    @JsonManagedReference
//    @Column(name = "restid")
    private Restaurant restaurant;

    public Food() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", foodname='" + foodname + '\'' +
                ", price=" + price +
                ", restid="  +
                ", restaurant=" + restaurant +
                '}';
    }
}
