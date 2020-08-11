package com.foodLover.api.repository;

import com.foodLover.api.entity.Food;
import com.foodLover.api.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Query(
            value = "select * from restaurant where rating> :rating",
            nativeQuery = true)
    List<Restaurant> restaurantRatings(@Param("rating") Double rating);



    @Query(
            value = "select * from restaurant where destinationid in " +
                    "(select id from destination where thedestination=:destName)",
            nativeQuery = true)
    List<Restaurant> restaurantDestinations(@Param("destName") String destName);
}


