package com.JEONG.restaurant.application;

import com.JEONG.restaurant.domain.MenuItem;
import com.JEONG.restaurant.domain.MenuItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class MenuItemServiceTests {
    private MenuItemService menuItemService;
    @Mock
    private MenuItemRepository menuItemRepository;
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        menuItemService = new MenuItemService(menuItemRepository);
    }
    @Test
    public void bulkUpdate(){
        List<MenuItem> menuItems= new ArrayList<MenuItem>();

        MenuItem menuItem = new MenuItem();
        menuItem.setName("Kimchi");
        menuItems.add(menuItem);

        MenuItem menuItem2 = new MenuItem();
        menuItem.setName("Gogbob");
        menuItems.add(menuItem2);

        menuItemService.bulkUpdate(1L, menuItems);

        verify(menuItemRepository, times(2)).save(any());
    }

}