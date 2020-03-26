package com.JEONG.restaurant.application;

import com.JEONG.restaurant.domain.User;
import com.JEONG.restaurant.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String email, String name, String password) {
        Optional<User> existed = Optional.ofNullable(userRepository.findByEmail(email));
        if (existed.isPresent()){
            throw new UserExistedException(email);
        }


        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        User user  = User.builder()
                .email(email)
                .name(name)
                .password(encodedPassword)
                .level(1L)
                .build();
         return userRepository.save(user);

    }

    public void authenticate(String email, String password) {
        //todo
    }
}
