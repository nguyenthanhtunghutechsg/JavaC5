package com.hutech.tests3.Controllers;

import com.hutech.tests3.Entities.CustomUserDetail;
import com.hutech.tests3.Entities.User;
import com.hutech.tests3.RequestEntities.RegisterUser;
import com.hutech.tests3.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String Register(Model model){
        RegisterUser registerUser = new RegisterUser();
        model.addAttribute("registerUser", registerUser);
        return "Layout/Auth/register";
    }
    @PostMapping("/register_submit")
    public String SubmitRegister(RegisterUser registerUser){
        User user = userService.userRegister(registerUser);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String Login(){
        return "Layout/Auth/login";
    }
    @GetMapping("/me")
    public String GetCurrentUser(@AuthenticationPrincipal CustomUserDetail customUserDetail, Model model){
        model.addAttribute("user", customUserDetail.getUser());
        return "Layout/Auth/currentUser";
    }
    @GetMapping("/change_password")
    public String  ChangePassword(@AuthenticationPrincipal CustomUserDetail customUserDetail, Model model){
        model.addAttribute("user", customUserDetail.getUser());
        return "Layout/Auth/changepassword";
    }
    @PostMapping("change_password")
    public String SavePassword(@AuthenticationPrincipal CustomUserDetail customUserDetail,
                                @RequestParam("oldpassword") String oldPassword,
                               @RequestParam("newpassword") String newpassword){
        User user = customUserDetail.getUser();
        if(userService.checkOldPassword(user, oldPassword)){
            userService.UpdatePassword(user, newpassword);
            return "redirect:/change_password?done";
        }else{
            return "redirect:/change_password?error";
        }
    }
}
