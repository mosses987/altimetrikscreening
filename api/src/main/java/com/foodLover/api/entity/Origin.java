package com.foodLover.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "origin")
public class Origin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String  originame;

    @OneToMany(mappedBy = "origin")
    @JsonBackReference
    private List<Destination> destinations;

    public Origin() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginame() {
        return originame;
    }

    public void setOriginame(String originame) {
        this.originame = originame;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }
}
