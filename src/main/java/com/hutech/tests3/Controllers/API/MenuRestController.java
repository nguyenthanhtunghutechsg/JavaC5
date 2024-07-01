package com.hutech.tests3.Controllers.API;

import com.hutech.tests3.Entities.Menu;
import com.hutech.tests3.Services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuRestController {
    @Autowired
    private MenuService menuService;
    @CrossOrigin
    @GetMapping("")
    public List<Menu> getMenus() {
        return menuService.getMenus();
    }
}
