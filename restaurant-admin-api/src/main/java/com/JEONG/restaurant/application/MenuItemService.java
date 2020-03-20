package com.JEONG.restaurant.application;

import com.JEONG.restaurant.domain.MenuItem;
import com.JEONG.restaurant.domain.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MenuItemService {

    private MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemService(MenuItemRepository menuItemRepository){
        this.menuItemRepository = menuItemRepository;
    }

    public  List<MenuItem> getMenuItems(Long restaurantId){

       return menuItemRepository.findAllByRestaurantId(restaurantId);

    }
    public void bulkUpdate(Long restaurantId, List<MenuItem> menuItems) {
        for (MenuItem menuItem : menuItems){
            update(restaurantId, menuItem);
        }


    }

    private void update(Long restaurantId, MenuItem menuItem) {
        if (menuItem.isDestroy()){
            menuItemRepository.deleteById(menuItem.getId());
            return;
        }
        menuItem.setRestaurantId(restaurantId); //레스토랑과 연결
        menuItemRepository.save(menuItem);
    }
}
