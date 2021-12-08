package com.example.codereview.controller;
import com.example.codereview.model.user.User;
import com.example.codereview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
@Autowired
private UserService userService;

    @RequestMapping(value = "/home")
    private String getHome(){
        return "Home";
    }

    @RequestMapping(value = "/getUsersData")
    private List<User> getUsersData(){
        return userService.getUsers();
    }


   /* Uncomment this when you will work on 2nd question of MySQL section
   @PostMapping(value = "/addUserData")
    private void addUserData(UserData userData){
        // TODO here you will implement the userData bussiness logic for the second question of MySQL section
    }*/
}
