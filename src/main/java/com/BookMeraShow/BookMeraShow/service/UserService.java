package com.BookMeraShow.BookMeraShow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookMeraShow.BookMeraShow.Entities.User;
import com.BookMeraShow.BookMeraShow.dao.UserRepo;

@Service("user_service")
public class UserService {

     @Autowired
     public UserRepo userRepo;
     
     public User save(User newUser) {
          System.out.println("service" + newUser);
          userRepo.save(newUser);
          return newUser;
     }
     
}
