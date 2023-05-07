package com.BookMeraShow.BookMeraShow.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {

     @JsonIgnore
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long movieId;

     private String movieName;

     private String duration;

     private String description;

     private String casts;

     private Integer rating;

     @JsonIgnore
     @OneToOne(mappedBy = "movie")
     public Show show;

     public Show getShow() {
          return show;
     }

     public void setMovieId(Long movieId) {
          this.movieId = movieId;
     }

     public Long getMovieId() {
          return movieId;
     }

     public void setMovieName(String movieName) {
          this.movieName = movieName;
     }

     public String getMovieName() {
          return movieName;
     }

     public void setDuration(String duration) {
          this.duration = duration;
     }

     public String getDuration() {
          return duration;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public String getDescription() {
          return description;
     }

     public void setCasts(String casts) {
          this.casts = casts;
     }

     public String getCasts() {
          return casts;
     }

     public void setRating(Integer rating) {
          this.rating = rating;
     }

     public Integer getRating() {
          return rating;
     }

     public Movie(Long movieId, String name, String duration, String description, String casts, Integer rating,
               Show show) {
          this.movieId = movieId;
          this.movieName = name;
          this.duration = duration;
          this.description = description;
          this.casts = casts;
          this.rating = rating;
          this.show = show;
     }

     public Movie() {
          super();
     }

     @Override
     public String toString() {
          String result = "movieName : " + this.movieName + "\n" + "movieDescription : " + this.description + "\n" + "movieDuration : " + this.duration + "\n" + "casts : " + this.casts + "\n" + "rating : " + this.rating;
          return result;
     }
}
