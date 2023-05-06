package com.BookMeraShow.BookMeraShow.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_booking")
public class Booking {
     @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private long bookingId;

     @Column(name = "seat_id")
     private int seatId;

     @Column(name = "seat_status")
     private String seatStatus;

     @Column(name = "created_at")
     private Date createdAt;

     @Column(name = "number_seats_booked_by_user")
     private int numberOfSeatsBookedByUser;

     public void setNumberOfSeatsBookedByUser(int numberOfSeatsBookedByUser) {
          this.numberOfSeatsBookedByUser = numberOfSeatsBookedByUser;
     }

     public int getNumberOfSeatsBookedByUser() {
          return numberOfSeatsBookedByUser;
     }

     public void setBookingId(long bookingId) {
          this.bookingId = bookingId;
     }

     public long getBookingId() {
          return bookingId;
     }

     public void setSeatId(int seatId) {
          this.seatId = seatId;
     }

     public int getSeatId() {
          return seatId;
     }

     public void setSeatStatus(String seatStatus) {
          this.seatStatus = seatStatus;
     }

     public String getSeatStatus() {
          return seatStatus;
     }

     public void setCreatedAt(Date createdAt) {
          this.createdAt = createdAt;
     }

     public Date getCreatedAt() {
          return createdAt;
     }

     public Booking(long bookingId, int seatId, String seatStatus, Date createdAt, int numberOfSeatsBookedByUser) {
          this.bookingId = bookingId;
          this.seatId = seatId;
          this.seatStatus = seatStatus;
          this.createdAt = createdAt;
          this.numberOfSeatsBookedByUser = numberOfSeatsBookedByUser;
     }

     public Booking() {
          super();
     }

}
