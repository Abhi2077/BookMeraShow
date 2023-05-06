package com.BookMeraShow.BookMeraShow.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
     @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private long movieId;
	@Column(name = "movie_name")
	private String movieName;
	@Column(name = "duration")
	private String duration;
	@Column(name = "rating")
	private int rating;
	@Column(name = "cast")
	private String cast;

     public void setMovieId(long movieId) {
          this.movieId = movieId;
     }
     
     public long getMovieId() {
          return movieId;
     }

     public void setMovieName(String movieName) {
          this.movieName = movieName;
     }

     public String getMovieName() {
          return movieName;
     }

     public void setMovieDuration(String movieDuration) {
          this.duration = movieDuration;
     }

     public String getMovieDuration() {
          return duration;
     }

     public void setMovieRating(int movieRating) {
          this.rating = movieRating;
     }

     public int getMovieRating() {
          return rating;
     }

     public void setMovieCast(String cast) {
          this.cast = cast;
     }

     public String getMovieCast() {
          return cast;
     }

     public Movie(long movieId, String movieName, String duration, int rating, String cast) {
          this.cast = cast;
          this.rating = rating;
          this.movieId = movieId;
          this.duration = duration;
          this.movieName = movieName;
     }

     public Movie() {
          super();
     }
}
