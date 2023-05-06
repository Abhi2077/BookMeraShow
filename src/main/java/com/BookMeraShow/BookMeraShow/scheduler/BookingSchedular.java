package com.BookMeraShow.BookMeraShow.scheduler;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
// import org.springframework.scheduling.annotation.Scheduled;

import com.BookMeraShow.BookMeraShow.dao.BookingRepo;
import com.BookMeraShow.BookMeraShow.Entities.Booking;

@Configuration
@EnableScheduling
public class BookingSchedular {
     
     @Autowired
     public BookingRepo bookingRepo;

     // @Scheduled(fixedDelay = 100000)
     public void updateBookingAndSeatStatus() throws ParseException {
     
          List<Booking> bookingList = bookingRepo.getBookingList();
          System.out.println("entered block");
          for (Booking booking : bookingList) {

               if(booking.getSeatStatus().equals("locked")) {

                    Date currentDate = new Date();
                    Date lockingDate = booking.getCreatedAt();
                    long difference_In_Time = currentDate.getTime() - lockingDate.getTime();

                    long difference_In_Minutes = (difference_In_Time / (1000 * 60)) % 60;
                    if(difference_In_Minutes > 5) {
                         System.out.println("revert locking");
                    }
               } else {
                    System.out.println("testmsg");
               }
          }
     }
     
}
