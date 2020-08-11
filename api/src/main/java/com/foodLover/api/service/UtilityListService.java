package com.foodLover.api.service;

import com.foodLover.api.entity.Destination;
import com.foodLover.api.entity.Food;
import com.foodLover.api.entity.Restaurant;
import com.foodLover.api.model.Summary;
import com.foodLover.api.repository.BookingRespository;
import com.foodLover.api.repository.DestinationRepository;
import com.foodLover.api.repository.FoodRepository;
import com.foodLover.api.repository.RestaurantRepository;
import com.foodLover.api.util.TimeUtitlity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Service
public class UtilityListService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private BookingRespository bookingRespository;

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private TimeUtitlity timeUtitlity;

    Map<String, Integer> countMap = null;

    public List<Food> getFoodListService(String restName, String destName){
        return foodRepository.foodDetails(restName,destName);
    }


    public List<Restaurant> getRestaurantRatingService(Double rating){
        return restaurantRepository.restaurantRatings(rating);
    }



    public List<Restaurant> getRestaurantDestinationService(String destination){
        System.out.println(timeUtitlity.theTime());
        return restaurantRepository.restaurantDestinations(destination);
    }

    public Summary getSummary(String username){

        List<String> theListOfFood = bookingRespository.findTheFood(username);
        List<Food> theFoodList = new ArrayList<>();
        Summary theSummary = new Summary();


        theListOfFood.stream().forEach(i->{
            theFoodList.add(foodRepository.findByFoodname(i));
        });

        theFoodList.stream().forEach(i->{
            theSummary.getFoodName().add(i.getFoodname());
            theSummary.getRestaurantName().add(i.getRestaurant().getRestname());
            theSummary.setUsername(username);
        });

        double totalPrice = -1;
        for(Food theFood: theFoodList){
            totalPrice=0;
            totalPrice += theFood.getPrice();
        }

        if(timeUtitlity.theTime()){

            if(totalPrice>250){
                totalPrice = totalPrice-totalPrice*0.35;
            }else {
                totalPrice = totalPrice-totalPrice*0.2;
            }
        }
        theSummary.setTotalPrice(totalPrice);
        System.out.println(theSummary);

        return theSummary;
    }


    public List<Destination> availableDestinationService(String originName){
        return destinationRepository.availableDestinations(originName);
    }


}
