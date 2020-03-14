package com.JEONG.restaurant.application;


import com.JEONG.restaurant.domain.Restaurant;
import com.JEONG.restaurant.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository= restaurantRepository;
    }
    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants =restaurantRepository.findAll();
        return restaurants;
    }


    public Restaurant getRestaurant(Long id){

        Restaurant restaurant = restaurantRepository.findById(id);
        return restaurant;
    }

}
