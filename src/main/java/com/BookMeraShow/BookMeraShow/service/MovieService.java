package com.BookMeraShow.BookMeraShow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookMeraShow.BookMeraShow.Entities.Movie;
import com.BookMeraShow.BookMeraShow.dao.MovieRepo;

@Service("movie_service")
public class MovieService {

     @Autowired
     public MovieRepo movieRepo;

     public Movie save(Movie newMovie) {
          movieRepo.save(newMovie);
          return newMovie;
     }

     public Optional<Movie> getMovieByID(long id) {
          Optional<Movie> movie = movieRepo.findById(id);
          return movie;
     }

     public List<Movie> getAllMovies() {
          List<Movie> movies = movieRepo.findAll();
          return movies;
     }

     public void deleteMovieByID(long id) {
          System.out.println("id of movie is " + id);
          movieRepo.deleteById(id);
     }
}
