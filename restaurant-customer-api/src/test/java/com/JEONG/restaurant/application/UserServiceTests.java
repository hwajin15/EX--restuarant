package com.JEONG.restaurant.application;

import com.JEONG.restaurant.domain.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class UserServiceTests {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void registerUser(){
        String email = "test@example.com";
        String name = "tester";
        String password = "test";
        userService.registerUser(email,name,password);

        verify(userRepository).save(any());
    }
//    @Test
//    public void registerUserWithExistedEmail(){
//        String email = "test@example.com";
//        String name = "tester";
//        String password = "test";
//        User user = User.builder().build();
//        given(userRepository.findByEmail(email)).willReturn(user);
//
//        userService.registerUser(email,name,password);
//
//        verify(userRepository, never()).save(any());
 //   }

}