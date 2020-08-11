package com.foodLover.api.repository;

import com.foodLover.api.entity.Booking;
import com.foodLover.api.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRespository extends JpaRepository<Booking, Integer> {

    @Query(
            value = "select foodname from booking where username= :username",
            nativeQuery = true)
    List<String> findTheFood(@Param("username") String username);

    List<Booking> findByUsername(@Param("username") String username);
}
