package com.hutech.tests3.Services;


import com.hutech.tests3.Entities.Category;
import com.hutech.tests3.Entities.Menu;
import com.hutech.tests3.Repositories.CategoryRepository;
import com.hutech.tests3.Repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getMenus() {
        return menuRepository.findAll();
    }
    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }
}
