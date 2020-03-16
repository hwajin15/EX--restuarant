package com.JEONG.restaurant.interfaces;

import com.JEONG.restaurant.application.RestaurantService;
import com.JEONG.restaurant.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;


    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        List<Restaurant> restaurants= restaurantService.getRestaurants();
        return restaurants;

    }
    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id")Long id){
        Restaurant restaurant =restaurantService.getRestaurant(id);
        return restaurant ;
    }
    @PostMapping("/restaurants")
    public ResponseEntity<?> create() throws URISyntaxException {
        Restaurant restaurant = new Restaurant(1234L,"BeRyong","Busan");
        restaurantService.addRestaurant(restaurant);
        URI location = new URI("/restaurants/1234");
        return ResponseEntity.created(location).body("{}");
    }
}