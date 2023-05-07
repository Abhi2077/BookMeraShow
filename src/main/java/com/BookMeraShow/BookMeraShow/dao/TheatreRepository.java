package com.BookMeraShow.BookMeraShow.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.BookMeraShow.BookMeraShow.entities.Theatre;

public interface TheatreRepository extends CrudRepository<Theatre, Long> {
     
     @Query(nativeQuery = true, value = "select * from theatres t where t.theatre_id = :theatreId")
     public Theatre getById(Long theatreId);
}
