package com.example.RegAndLogWithSecure.userThings;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class userController {


    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public List<Users> home(){

        return userService.getUsers();
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute Users user) {
        user.setRole("ROLE_USER");
        userService.save(user);
        return "redirect:/login";
    }


}
