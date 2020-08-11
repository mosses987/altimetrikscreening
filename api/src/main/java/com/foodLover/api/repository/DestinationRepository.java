package com.foodLover.api.repository;

import com.foodLover.api.entity.Destination;
import com.foodLover.api.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface DestinationRepository extends JpaRepository<Destination, Integer> {


    @Query(
            value = "select * " +
                    "from destination where originid in " +
                    "(select id from origin where originame= :originName)",
            nativeQuery = true)
    List<Destination> availableDestinations(@Param("originName") String originName);



}
