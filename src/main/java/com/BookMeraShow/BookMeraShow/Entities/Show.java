package com.BookMeraShow.BookMeraShow.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movie_show")
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "show_id")
	private int showId;

     //ref to theatre
     @Column(name = "theatre_id")
     private int theatreId;

     @Column(name = "seats_booked")
     private int seatsBooked;

     @Column(name = "seats_available")
     private int seatsAvailabe;

     public void setShowId(int showId) {
          this.showId = showId;
     }

     public int getShowId() {
          return showId;
     }

     public void setTheatreId(int theatreId) {
          this.theatreId = theatreId;
     }

     public int getTheatreId() {
          return theatreId;
     }

     public void setSeatsBooked(int seatsBooked) {
          this.seatsBooked = seatsBooked;
     }

     public int getSeatsBooked() {
          return seatsBooked;
     }

     public void setSeatsAvailable(int seatsAvailabe) {
          this.seatsAvailabe = seatsAvailabe;
     }

     public int getSeatsAvailable() {
          return seatsAvailabe;
     }
     public Show(int showId, int theatreId, int seatsAvailabe, int seatsBooked) {
          this.showId = showId;
          this.seatsAvailabe = seatsAvailabe;
          this.seatsBooked = seatsBooked;
          this.showId = showId;
     }

     public Show() {
          super();
     }

    


}
