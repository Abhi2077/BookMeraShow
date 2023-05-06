package com.BookMeraShow.BookMeraShow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BookMeraShow.BookMeraShow.Entities.Show;
import com.BookMeraShow.BookMeraShow.service.BookingService;
import com.BookMeraShow.BookMeraShow.service.ShowService;

@RestController
public class BookingController {

     @Autowired
     public ShowService showService;

     @Autowired
     public BookingService bookingService;
     
     @PostMapping("/bookseats/{noOfSeatsToBeBooked}/{theatreId}")
     public String bookSeats(@RequestParam int noOfSeatsToBeBooked, @RequestParam int theatreId) {

          
          System.out.println("theatreId is : " + theatreId);
          System.out.println("number of seats is : " + noOfSeatsToBeBooked);
          
          bookingService.bookUserSeats(noOfSeatsToBeBooked, theatreId);
          // bookingService.updateBookingStatus()
          // bookingService.bookUserSeats(1, 5);
          return "temp";
     }

     //temp api to add show
     @PostMapping("/addShow")
     public String addShow(@RequestBody Show show) {
          showService.addNewShow(show);
          return "show added successfully!!";
     }

}

//show -> theatre_id, time, seatsBooked, seatsAvailable