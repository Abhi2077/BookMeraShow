package com.BookMeraShow.BookMeraShow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookMeraShow.BookMeraShow.dao.ShowRepository;
import com.BookMeraShow.BookMeraShow.dao.TicketRepository;
import com.BookMeraShow.BookMeraShow.entities.Show;
import com.BookMeraShow.BookMeraShow.entities.Ticket;
import com.BookMeraShow.BookMeraShow.exceptions.ExceededCapacityException;

import jakarta.transaction.Transactional;

@Service("booking_service")
public class BookingService {
     
     @Autowired
     public ShowRepository showRepository;

     @Autowired
     public TicketRepository ticketRepository;

     @Transactional
     public void book(Long showId, Integer noOfSeatsToBeBooked) throws ExceededCapacityException {
          Show show = showRepository.findWithLockingById(showId);
          if(noOfSeatsToBeBooked > show.getShowCapacity()) {
               throw new ExceededCapacityException();
          } else {
               //updating no. of avialable seats
               show.setShowCapacity(show.getShowCapacity() - noOfSeatsToBeBooked);
               Ticket ticket = new Ticket();
               ticket.setNoOfSeatsBooked(noOfSeatsToBeBooked);
               ticket.setStatus("locked");
               ticket.setShow(show);
               ticketRepository.save(ticket);
          }
     }
}
