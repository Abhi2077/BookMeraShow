package com.BookMeraShow.BookMeraShow.dao;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.BookMeraShow.BookMeraShow.entities.Show;

import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;

public interface ShowRepository extends CrudRepository<Show, Long> { 

     @Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
     Show findWithLockingById(Long id);

     Show getById(Long id);

     @Transactional
     @Modifying
     @Query(nativeQuery = true, value = "update shows s set s.no_of_available_seats = :newAvailableNoOfSeats where s.id = :id")
     public void updateNoOfSeatsAvailableById(Integer newAvailableNoOfSeats, Long id);

     @Query(nativeQuery = true, value = "select * from shows s where s.id =:showId")
     public Show getShowById(Long showId);

}
