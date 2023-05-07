package com.BookMeraShow.BookMeraShow.entities;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "shows")
public class Show {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private Date showTime;

     private Integer capacity;

     @OneToMany(mappedBy = "show")
     private Set<Ticket> tickets;

     @OneToOne()
     @JoinColumn(name = "movieId")
     private Movie movie;

     @ManyToOne
     @JoinColumn(name = "theatreId")
     private Theatre theatre;

     @Version
     private Integer version;

     public void setMovie(Movie movie) {
          this.movie = movie;
     }

     public Movie getMovie() {
          return movie;
     }

     public void setTickets(Set<Ticket> tickets) {
          this.tickets = tickets;
     }

     public Set<Ticket> getTickets() {
          return tickets;
     }

     public void setShowId(Long id) {
          this.id = id;
     }

     public Long getShowId() {
          return id;
     }

     public void setShowTime(Date showTime) {
          this.showTime = showTime;
     }

     public Date getShowTime() {
          return showTime;
     }
     
     public void setShowCapacity(Integer capacity) {
          this.capacity = capacity;
     }

     public Integer getShowCapacity() {
          return capacity;
     }

     public void addTicket(Ticket ticket) {
          ticket.setShow(this);
          getTickets().add(ticket);
     }

}
