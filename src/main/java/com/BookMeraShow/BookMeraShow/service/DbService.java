package com.BookMeraShow.BookMeraShow.service;

import org.springframework.stereotype.Service;

import com.BookMeraShow.BookMeraShow.dao.ShowRepository;
import com.BookMeraShow.BookMeraShow.dao.TicketRepository;
import com.BookMeraShow.BookMeraShow.entities.Show;
import com.BookMeraShow.BookMeraShow.entities.Ticket;
import com.BookMeraShow.BookMeraShow.exceptions.ExceededCapacityException;

import jakarta.transaction.Transactional;

@Service
public class DbService {

     private final ShowRepository showRepository;

     private final TicketRepository ticketRepository;

     public DbService(ShowRepository showRepository, TicketRepository ticketRepository) {
          this.showRepository = showRepository;
          this.ticketRepository = ticketRepository;
     }

     private void saveNewTicket(Integer noOfSeatsBooked, Show show, String status) throws Exception {
          System.out.println("show capacity : " + show.getShowCapacity());
          System.out.println("tickets are : " + show.getTickets().size());
          if (show.getShowCapacity() <= show.getTickets().size()) {
               throw new ExceededCapacityException();
          }
          var ticket = new Ticket();
          ticket.setNoOfSeatsBooked(noOfSeatsBooked);
          ticket.setStatus(status);
          show.addTicket(ticket);
          ticketRepository.save(ticket);
     }

     @Transactional
     public void changeShow1() throws Exception {
          // the code of the first thread
          var show = showRepository.findWithLockingById(1L);
          saveNewTicket(1, show, "booked");
          Thread.sleep(1_000);
     }

     @Transactional
     public void changeShow2() throws Exception {
          // the code of the second thread
          var show = showRepository.findWithLockingById(1L);
          saveNewTicket(1, show, "booked");
          Thread.sleep(1_000);
     }

}
