package com.BookMeraShow.BookMeraShow.service;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookMeraShow.BookMeraShow.dao.ShowRepository;
import com.BookMeraShow.BookMeraShow.dao.TicketRepository;
import com.BookMeraShow.BookMeraShow.entities.Show;
import com.BookMeraShow.BookMeraShow.entities.Ticket;
import com.BookMeraShow.BookMeraShow.exceptions.ExceededCapacityException;

import jakarta.transaction.Transactional;

@Service
public class BookingService {

     @Autowired
     public ShowRepository showRepository;

     @Autowired
     public TicketRepository ticketRepository;

     private static int LOCK_TIMEOUT_MINUTES = 1;

     @Transactional
     public void book(Long showId, Integer noOfSeatsToBeBooked) throws ExceededCapacityException {
          Show show = showRepository.findWithLockingById(showId);
          if (noOfSeatsToBeBooked > show.getShowCapacity()) {
               throw new ExceededCapacityException();
          } else {
               // updating no. of avialable seats
               show.setShowCapacity(show.getShowCapacity() - noOfSeatsToBeBooked);
               Ticket ticket = new Ticket();
               ticket.setNoOfSeatsBooked(noOfSeatsToBeBooked);
               ticket.setStatus("locked");
               ticket.setShow(show);
               ticketRepository.save(ticket);

               scheduleRevertTask(ticket.getTicketId());
          }
     }

     public void scheduleRevertTask(long ticketId) {

          // Set a timer to revert the booking after the lock timeout
          Timer timer = new Timer();
          timer.schedule(new TimerTask() {
               @Override
               public void run() {
                    System.out.println("running scheduled task");
                    Ticket storedTicket = ticketRepository.findById(ticketId).get();
                    System.out.println("stored ticket is : " + storedTicket.getTicketId() + " status : " + storedTicket.getStatus());
                    if (storedTicket != null && "locked".equals(storedTicket.getStatus())) {
                         // Revert the booking
                         storedTicket.setStatus("reverted");

                         Show show = showRepository.getById(storedTicket.getShow().getShowId());
                         Integer newAvailableNoOfSeats = show.getShowCapacity() + storedTicket.getNoOfSeatsBooked();

                         ticketRepository.save(storedTicket);
                         showRepository.updateNoOfSeatsAvailableById(newAvailableNoOfSeats, show.getShowId());
                    }
               }
          }, LOCK_TIMEOUT_MINUTES * 60 * 1000);
     }

     public Ticket getTicketById(Long ticketId) {
          return ticketRepository.getTicketById(ticketId);
     }

     public void updateTicketStatusById(Long ticketId) {
          ticketRepository.updateTicketStatusById(ticketId);
     }

     public void cancelTicketById(Long ticketId) {

          Long showId = getTicketById(ticketId).getShow().getShowId();
          Show show = showRepository.getShowById(showId);
          System.out.println("show id is : " + show.getShowId());
          System.out.println("show capcity is : " + show.getShowCapacity());
          Integer newAvailableSeats = show.getShowCapacity() + getTicketById(ticketId).getNoOfSeatsBooked();
          showRepository.updateNoOfSeatsAvailableById(newAvailableSeats, showId);
          ticketRepository.updateTicketStatusCancel(ticketId);
     }
}
