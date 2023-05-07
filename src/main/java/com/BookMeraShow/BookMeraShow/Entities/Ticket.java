package com.BookMeraShow.BookMeraShow.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "show_id")
     private Show show;

     private String seatDetails;

     public void setTicketId(Long id) {
          this.id = id;
     }

     public Long getTicketId() {
          return id;
     }

     public void setSeatDetails(String seatDetails) {
          this.seatDetails = seatDetails;
     }

     public String getSeatDetails() {
          return seatDetails;
     }

     public void setShow(Show show) {
          this.show = show;
     }

     public Show getShow() {
          return show;
     }
}