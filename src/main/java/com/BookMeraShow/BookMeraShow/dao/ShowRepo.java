package com.BookMeraShow.BookMeraShow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BookMeraShow.BookMeraShow.Entities.Show;

import jakarta.transaction.Transactional;


@Repository("show_repo")
public interface ShowRepo extends JpaRepository<Show, Integer> {
     
     @Transactional
     @Modifying
     @Query(nativeQuery = true, value = "update movie_show m set m.seats_available = :newAvailableNoOfSeats where m.theatre_id = :theatreId")
     public void updateNoOfSeatsAvailableById(@Param("newAvailableNoOfSeats") int newAvailableNoOfSeats, @Param("theatreId") int theatreId);

     @Transactional
     @Modifying
     @Query(nativeQuery = true, value = "update movie_show m set m.seats_booked = :newTotalBookedSeats where m.theatre_id = :theatreId")
     public void updateNoOfBookedSeatsById(@Param("newTotalBookedSeats") int newTotalBookedSeats, @Param("theatreId") int theatreId);
}
