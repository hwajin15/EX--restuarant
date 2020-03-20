package com.JEONG.restaurant.application;


import com.JEONG.restaurant.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RestaurantService {
    private RestaurantRepository restaurantRepository;
 @Autowired
   public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants =restaurantRepository.findAll();
        return restaurants;
    }


    public Restaurant getRestaurant(Long id){
        Restaurant restaurant = restaurantRepository.findById(id).
                orElseThrow(() -> new RestaurantNotFoundException(id));


        return restaurant;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        Restaurant saved = restaurantRepository.save(restaurant);

        return saved;
    }

    public Restaurant updateRestaurant(Long id, String name, String address) {
        Restaurant restaurant =restaurantRepository.findById(id).orElseThrow(()->new RestaurantNotFoundException(id));
       restaurant.updateInformation(name,address);


        return restaurant;
    }
}
