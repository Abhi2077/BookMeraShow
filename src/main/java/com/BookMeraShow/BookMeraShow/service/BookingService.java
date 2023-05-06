package com.BookMeraShow.BookMeraShow.service;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookMeraShow.BookMeraShow.Entities.Booking;
import com.BookMeraShow.BookMeraShow.Entities.Show;
import com.BookMeraShow.BookMeraShow.dao.BookingRepo;
import com.BookMeraShow.BookMeraShow.dao.ShowRepo;

import jakarta.transaction.Transactional;

@Service("booking_service")
public class BookingService {
     @Autowired
     public ShowRepo showRepo;

     @Autowired
     public BookingRepo bookingRepo;

     private static int LOCK_TIMEOUT_MINUTES = 1;

     @Transactional
     public void bookUserSeats(int noOfSeatsToBeBooked, int theatreId) {
          Show show = showRepo.getById(theatreId);
          if (show.getSeatsAvailable() >= noOfSeatsToBeBooked) {
               
               int newAvailableNoOfSeats = show.getSeatsAvailable() - noOfSeatsToBeBooked;
               int newTotalBookedSeats = show.getSeatsBooked() + noOfSeatsToBeBooked;
               System.out.print("seats are : " + newTotalBookedSeats);
               showRepo.updateNoOfSeatsAvailableById(newAvailableNoOfSeats, theatreId);
               showRepo.updateNoOfBookedSeatsById(newTotalBookedSeats, theatreId);

               // Create a new booking with status as "locked"
               Booking booking = new Booking();
               booking.setSeatId(show.getShowId());
               booking.setNumberOfSeatsBookedByUser(noOfSeatsToBeBooked);
               booking.setSeatStatus("locked");
               booking.setCreatedAt(new Date());

               // Save the booking
               booking = bookingRepo.save(booking);

               scheduleRevertTask(booking.getBookingId());

          }
     }

     public void scheduleRevertTask(long bookingId) {

          // Set a timer to revert the booking after the lock timeout
          Timer timer = new Timer();
          timer.schedule(new TimerTask() {
               @Override
               public void run() {
                    Booking storedBooking = bookingRepo.findById(bookingId).get();
                    if (storedBooking != null && "locked".equals(storedBooking.getSeatStatus())) {
                         // Revert the booking
                         storedBooking.setSeatStatus("reverted");
                         Show show = showRepo.getById(storedBooking.getSeatId());
                         int newAvailableNoOfSeats = show.getSeatsAvailable() + storedBooking.getNumberOfSeatsBookedByUser();
                         int newTotalBookedSeats = show.getSeatsBooked() - storedBooking.getNumberOfSeatsBookedByUser();
                         showRepo.updateNoOfSeatsAvailableById(newAvailableNoOfSeats, show.getShowId());
                         showRepo.updateNoOfBookedSeatsById(newTotalBookedSeats, show.getShowId());
                         bookingRepo.save(storedBooking);
                    }
               }
          }, LOCK_TIMEOUT_MINUTES * 60 * 1000);

     }
}
