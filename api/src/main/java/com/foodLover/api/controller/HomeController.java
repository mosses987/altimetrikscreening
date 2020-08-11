package com.foodLover.api.controller;

import com.foodLover.api.entity.Booking;
import com.foodLover.api.entity.Destination;
import com.foodLover.api.entity.Food;
import com.foodLover.api.entity.Restaurant;
import com.foodLover.api.model.Summary;
import com.foodLover.api.repository.BookingRespository;
import com.foodLover.api.repository.DestinationRepository;
import com.foodLover.api.repository.FoodRepository;
import com.foodLover.api.service.UtilityListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private UtilityListService utilityListService;

    @Autowired
    private BookingRespository bookingRespository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private DestinationRepository destinationRepository;


    @GetMapping("/availabledestinations")
    public List<Destination> theDestinations(@RequestParam(name = "originName") String originName){
        return utilityListService.availableDestinationService(originName);
    }

    @GetMapping("/thefood")
    public List<Food> theFood(@RequestParam(name = "restName") String restName,
                              @RequestParam(name = "destName") String destName){
        return utilityListService.getFoodListService(restName, destName);
    }

    @GetMapping("/restaurantrating")
    public List<Restaurant> theRestaurantRating(@RequestParam(name = "rating") Double rating){
        return utilityListService.getRestaurantRatingService(rating);
    }

    @GetMapping("/restaurantdestination")
    public List<Restaurant> theRestaurantDestination(@RequestParam(name = "destName") String destName){
        return utilityListService.getRestaurantDestinationService(destName);
    }

    @GetMapping("/bookingdetails")
    public Summary theBookingDetails(@RequestParam(name = "username") String username){
        Summary summary = utilityListService.getSummary(username);

        return summary;

    }

}
