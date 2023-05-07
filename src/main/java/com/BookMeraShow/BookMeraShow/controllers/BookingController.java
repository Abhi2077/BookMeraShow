package com.BookMeraShow.BookMeraShow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BookMeraShow.BookMeraShow.exceptions.ExceededCapacityException;
import com.BookMeraShow.BookMeraShow.service.BookingService;

@RestController
public class BookingController {
     
     @Autowired
     public BookingService bookingService;

     @PostMapping("/booking/{showId}/{noOfSeatsToBeBooked}") 
     public String userBooking(@RequestParam Long showId, @RequestParam Integer noOfSeatsToBeBooked) {

          try {
               bookingService.book(showId, noOfSeatsToBeBooked);
          } catch (ExceededCapacityException e) {
               e.printStackTrace();
               return "no seats available";
          }
          return "success";
     }
}
