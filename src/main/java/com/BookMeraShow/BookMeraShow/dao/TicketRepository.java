package com.BookMeraShow.BookMeraShow.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.BookMeraShow.BookMeraShow.entities.Ticket;

import jakarta.transaction.Transactional;

public interface TicketRepository extends CrudRepository<Ticket, Long> { 

     @Query(nativeQuery = true, value = "select * from tickets t where t.id =:ticketId")
     public Ticket getTicketById(Long ticketId);

     @Transactional
     @Modifying
     @Query(nativeQuery = true, value = "update tickets t set t.status = 'booked' where t.id =:ticketId")
     public void updateTicketStatusById(Long ticketId);

     @Transactional
     @Modifying
     @Query(nativeQuery = true, value = "update tickets t set t.status = 'cancelled' where t.id =:ticketId")
     public void updateTicketStatusCancel(Long ticketId);
}
