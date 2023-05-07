package com.BookMeraShow.BookMeraShow.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "theatres")
public class Theatre {
     
     @JsonIgnore
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long theatreId;

     private String name;

     private String location;

     private Integer seatCapacity;

     @JsonIgnore
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

     public Theatre(Long theatreId, String name, String location, Integer seatCapacity) {
          this.theatreId = theatreId;
          this.name = name;
          this.location = location;
          this.seatCapacity = seatCapacity;
     }

     public Theatre() {
          super();
     }

     @Override
     public String toString() {
          String result = "theatreName : " + this.name + "\n" + "location : " + this.location + "\n" + "seatCapacity : " + this.seatCapacity;
          return result;
     }
}
