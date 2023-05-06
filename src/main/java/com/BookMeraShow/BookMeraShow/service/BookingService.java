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
               // check status of seat (book)
               // int newAvailableNoOfSeats = show.getSeatsAvailable() - noOfSeatsToBeBooked;
               // int newTotalBookedSeats = show.getSeatsBooked() + noOfSeatsToBeBooked;
               // System.out.print("seats are : " + newTotalBookedSeats);
               // showRepo.updateNoOfSeatsAvailableById(newAvailableNoOfSeats, theatreId);
               // showRepo.updateNoOfBookedSeatsById(newTotalBookedSeats, theatreId);

               // Booking booking = new Booking();
               // booking.setSeatId(show.getShowId());
               // booking.setCreatedAt(new Date());
               // booking.setSeatStatus("locked");
               // booking.setNumberOfSeatsBookedByUser(noOfSeatsToBeBooked);

               // System.out.println("this booking element " + booking);
               // bookingRepo.save(booking);

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
                    Booking storedBooking = bookingRepo.findById(bookingId).orElse(null);
                    if (storedBooking != null && "locked".equals(storedBooking.getSeatStatus())) {
                         // Revert the booking
                         storedBooking.setSeatStatus("reverted");
                         bookingRepo.save(storedBooking);
                    }
               }
          }, LOCK_TIMEOUT_MINUTES * 60 * 1000);

     }
}
