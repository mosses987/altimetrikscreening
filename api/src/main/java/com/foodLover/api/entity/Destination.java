package com.foodLover.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "destination")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Integer id;

//    @Column(name = "thedestination")
    private String thedestination;

    @OneToMany(mappedBy = "destination")
    @JsonBackReference
    private Set<Restaurant> restaurant;


    //after implementation
    @ManyToOne
    @JoinColumn(name = "originid", insertable=false, updatable=false)
    @JsonManagedReference
    private Origin origin;



    public Destination() {
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThedestination() {
        return thedestination;
    }

    public void setThedestination(String thedestination) {
        this.thedestination = thedestination;
    }

    public Set<Restaurant> getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Set<Restaurant> restaurant) {
        this.restaurant = restaurant;
    }
}
