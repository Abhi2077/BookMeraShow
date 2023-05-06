package com.BookMeraShow.BookMeraShow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.BookMeraShow.BookMeraShow.Entities.User;
import com.BookMeraShow.BookMeraShow.service.UserService;

@RestController
@SessionAttributes({"email", "password", "userName", "mobileNumber"})
public class UserController {
          
     @Autowired
     private UserService userService;
     
     @GetMapping("/LoginUser")
     public String LoginUser() {
          return "LogInPage";
     }

     @GetMapping("/RegisterUser")
     public String RegisterUser() {
          return "RegisterPage";
     }

     @PostMapping("/SaveNewUser")
     public String SaveNewUser(@RequestBody User userDetails) {
          System.out.println("controller" + userDetails.getEmail());
          userService.save(userDetails);
          return "user saved in db";
     }
}
