package com.BookMeraShow.BookMeraShow.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
// import jakarta.persistence.criteria.CriteriaBuilder.In;

@Entity
@Table(name = "tickets")
public class Ticket {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "show_id")
     private Show show;

     private Integer noOfSeatsBooked;

     private String status;

     // private String seatDetails;

     public void setTicketId(Long id) {
          this.id = id;
     }

     public Long getTicketId() {
          return id;
     }

     public void setNoOfSeatsBooked(Integer noOfSeatsBooked) {
          this.noOfSeatsBooked = noOfSeatsBooked;
     }

     public Integer getNoOfSeatsBooked() {
          return noOfSeatsBooked;
     }

     public void setStatus(String status) {
          this.status = status;
     }

     public String getStatus() {
          return status;
     }

     // public void setSeatDetails(String seatDetails) {
     //      this.seatDetails = seatDetails;
     // }

     // public String getSeatDetails() {
     //      return seatDetails;
     // }

     public void setShow(Show show) {
          this.show = show;
     }

     public Show getShow() {
          return show;
     }

     public Ticket(Long id, Integer noOfSeatsBooked, String status) {
          this.id = id;
          this.noOfSeatsBooked = noOfSeatsBooked;
          this.status = status;
     }

     public Ticket() {
          super();
     }
}