package com.JEONG.restaurant.application;

import com.JEONG.restaurant.domain.Restaurant;
import com.JEONG.restaurant.domain.RestaurantRepository;
import com.JEONG.restaurant.domain.RestaurantRepositoryImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

class RestaurantServiceTest {
    private RestaurantService restaurantService;

    private RestaurantRepository restaurantRepository;

   @Before
   public void setUp(){
        restaurantRepository = new RestaurantRepositoryImpl();

       restaurantService = new RestaurantService(restaurantRepository);
    }

    @Test
    public void getRestaurants(){
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        Restaurant restaurant = restaurants.get(0);
        assertThat(restaurant.getId(),is(1004L));
    }
    @Test
    public void getRestaurant(){
        Restaurant restaurant = restaurantService.getRestaurant(1004L);
        assertThat(restaurant.getId(),is(1004L));
    }
}