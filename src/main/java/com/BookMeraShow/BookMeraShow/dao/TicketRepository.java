package com.BookMeraShow.BookMeraShow.dao;

import org.springframework.data.repository.CrudRepository;

import com.BookMeraShow.BookMeraShow.entities.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long> { }
