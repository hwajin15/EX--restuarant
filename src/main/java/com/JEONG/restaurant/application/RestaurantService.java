package com.JEONG.restaurant.application;


import com.JEONG.restaurant.domain.MenuItem;
import com.JEONG.restaurant.domain.MenuItemRepository;
import com.JEONG.restaurant.domain.Restaurant;
import com.JEONG.restaurant.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        Restaurant restaurant = restaurantRepository.findById(id);

        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItems);

        return restaurant;
    }

    public void addRestaurant(Restaurant restaurant) {
        //
    }
}
