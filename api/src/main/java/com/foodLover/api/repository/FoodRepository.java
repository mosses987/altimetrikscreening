package com.foodLover.api.repository;

import com.foodLover.api.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface FoodRepository extends JpaRepository<Food, Integer> {

    @Query(
            value = "select * from food where restid in \n" +
                    "(select rest.id from restaurant rest  inner join destination dest on \n" +
                    "rest.destinationid=dest.id where rest.restname= :restName \n" +
                    "and dest.thedestination= :destName)",
            nativeQuery = true)
    List<Food> foodDetails(@Param("restName") String restName,
                        @Param("destName") String destName);

    Food findByFoodname(String name);

    List<Food> findByPriceGreaterThan(@Param("price") Integer price);




}
