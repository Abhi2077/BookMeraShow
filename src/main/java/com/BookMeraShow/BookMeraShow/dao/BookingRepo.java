package com.BookMeraShow.BookMeraShow.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BookMeraShow.BookMeraShow.Entities.Booking;

@Repository("booking_repo")
public interface BookingRepo extends JpaRepository<Booking, Long> {

     @Query(nativeQuery = true, value = "select * from user_booking u where u.seat_status like '%locked%'")
     public List<Booking> getBookingList();
}