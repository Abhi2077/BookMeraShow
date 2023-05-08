package com.BookMeraShow.BookMeraShow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BookMeraShow.BookMeraShow.entities.Ticket;
import com.BookMeraShow.BookMeraShow.exceptions.ExceededCapacityException;
import com.BookMeraShow.BookMeraShow.service.BookingService;

@RestController
public class BookingController {
     
     @Autowired
     public BookingService bookingService;

     @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
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

     @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
     @PostMapping("/booking/cancelTicketById/{ticketId}")
     public String cancelTicketById(@RequestParam Long ticketId) {
          Ticket ticket = bookingService.getTicketById(ticketId);
          if(ticket == null)
               return "ticket does not exist";
          bookingService.cancelTicketById(ticketId);
          return "ticket cancelled";
     }

     @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
     @PostMapping("/booking/updateTicketStatusById/{ticketId}")
     public String updateTicketStatusById(@RequestParam Long ticketId) {
          Ticket ticket = bookingService.getTicketById(ticketId);
          if(ticket == null)
               return "ticket does not exist";
          bookingService.updateTicketStatusById(ticketId);
          return "ticket status updated";
     }
}
