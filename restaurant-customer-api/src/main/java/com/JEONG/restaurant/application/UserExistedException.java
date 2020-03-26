package com.JEONG.restaurant.application;

public class UserExistedException extends  RuntimeException {

    UserExistedException(String email){
        super("email is already existed" + email);
    }
}
