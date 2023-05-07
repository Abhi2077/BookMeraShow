package com.BookMeraShow.BookMeraShow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import com.BookMeraShow.BookMeraShow.entities.Show;
import com.BookMeraShow.BookMeraShow.service.ShowService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ShowController {

     @Autowired
     public ShowService showService;

     @PreAuthorize("hasRole('ADMIN')")
     @PostMapping("/show/addNewShow")
     public String addNewShow(@RequestBody Show show) {

          try {
               showService.addNewShow(show);
          } catch (Exception e) {
               return "error occurred!!";
          }
          return "show added successfully";
     }

     @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
     @GetMapping("/show/getShowById/{showId}")
     public String getShowById(@RequestParam Long showId) {
         Show show = showService.getShowById(showId);
         if(show == null)
               return "show does not exist!!";
          return show.toString();
     }

     @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
     @GetMapping("/show/getAllShow") 
     public List<Show> getAllShow() {
          List<Show> showList = showService.getAllShow();
          return showList;
     }
     
     @PreAuthorize("hasRole('ADMIN')")
     @DeleteMapping("/show/deleteShowById/{showId}")
     public String deleteShowById(Long showId) {
          Show show = showService.getShowById(showId);
          if(show == null)
               return "show does not exist";

          showService.deleteShowById(showId);
          return "show deleted successfully";
     }

}