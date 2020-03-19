package com.JEONG.restaurant.application;


import com.JEONG.restaurant.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    MenuItemRepository menuItemRepository;

    public RestaurantService(RestaurantRepository restaurantRepository,
                             MenuItemRepository menuItemRepository) {
        this.restaurantRepository= restaurantRepository;
        this.menuItemRepository =menuItemRepository;
    }

    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants =restaurantRepository.findAll();
        return restaurants;
    }


    public Restaurant getRestaurant(Long id){

        Restaurant restaurant = restaurantRepository.findById(id).
                orElseThrow(() -> new RestaurantNotFoundException(id));

        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItems);

        return restaurant;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        Restaurant saved = restaurantRepository.save(restaurant);

        return saved;
    }

    @Transactional
    public Restaurant updateRestaurant(Long id, String name, String address) {
        //todo:
        Restaurant restaurant =restaurantRepository.findById(id).orElseThrow(()->new RestaurantNotFoundException(id));
       restaurant.updateInformation(name,address);


        return restaurant;
    }
}
