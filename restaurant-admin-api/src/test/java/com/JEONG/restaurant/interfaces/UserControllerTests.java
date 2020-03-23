package com.JEONG.restaurant.interfaces;

import com.JEONG.restaurant.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private com.JEONG.restaurant.application.UserService UserService;

    @Test
    public void list() throws Exception {
        List<User> users = new ArrayList<>();
        users.add(User.builder()
        .email("test@example.com")
        .name("테스터")
        .level(1L)
        .build());

       given(UserService.getUsers()).willReturn(users);

        mvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("테스터")));

    }

    @Test
    public void create() throws Exception {
        String email = "admin@example.com";
        String name = "admin";
        User user = User.builder().email(email).name(name).build();
        given(UserService.addUser(email,name)).willReturn(user);
        mvc.perform(post("/users")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"email\":\"admin@example.com\",\"name\":\"admin\"}"))
                .andExpect(status().isCreated());


        verify(UserService).addUser(email,name);
    }
    @Test
    public void update() throws Exception {

        mvc.perform(patch("/users/1004")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"admin@example.com\",\"name\":\"admin\",\"level\":\"100\"}"))
                .andExpect(status().isOk());
    }
    @Test
    public void deactivate() throws Exception {
        mvc.perform(delete("/users/1004"))
                .andExpect(status().isOk());

        verify(UserService).deactiveUser(1004L);
    }
}