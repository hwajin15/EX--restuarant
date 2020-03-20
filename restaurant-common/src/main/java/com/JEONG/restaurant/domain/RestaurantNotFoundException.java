package com.JEONG.restaurant.domain;

public class RestaurantNotFoundException extends RuntimeException {


    public RestaurantNotFoundException(long id) {
        super("could not find restaurant " + id);
    }
}
