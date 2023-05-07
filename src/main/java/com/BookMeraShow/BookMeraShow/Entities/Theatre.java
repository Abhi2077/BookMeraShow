package com.BookMeraShow.BookMeraShow.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "theatres")
public class Theatre {
     
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long theatreId;

     private String name;

     private String location;

     private Integer seatCapacity;

     @OneToMany(mappedBy = "id")
     private List<Show> shows;

     public List<Show> getShows() {
          return shows;
     }

     public void setId(Long theatreId) {
          this.theatreId = theatreId;
     }

     public Long getId() {
          return theatreId;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getName() {
          return name;
     }

     public void setLocation(String location) {
          this.location = location;
     }

     public String getLocation() {
          return location;
     }

     public void setSeatCapacity(Integer seatCapacity) {
          this.seatCapacity = seatCapacity;
     }

     public Integer getSeatCapacity() {
          return seatCapacity;
     }

     public Theatre(Long id, String name, String location, Integer seatCapacity) {
          this.theatreId = id;
          this.name = name;
          this.location = location;
          this.seatCapacity = seatCapacity;
     }

     public Theatre() {
          super();
     }

}
