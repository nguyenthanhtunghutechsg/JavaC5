package com.hutech.ngay3c5.Controllers.Home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("")
    public String HomePage(){
        return "index";
    }
}
