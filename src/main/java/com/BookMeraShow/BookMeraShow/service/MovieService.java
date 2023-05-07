package com.BookMeraShow.BookMeraShow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookMeraShow.BookMeraShow.dao.MovieRepository;
import com.BookMeraShow.BookMeraShow.entities.Movie;

@Service
public class MovieService {
     @Autowired
     public MovieRepository movieRepository;

     public List<Movie> getAllMovies() {
          return (List<Movie>) movieRepository.findAll();
     }

     public Movie getMovieById(Long movieId) {
          // System.out.println("movie Id is "movieId);
          Movie movie = movieRepository.getById(movieId);
          System.out.println("movie obtained is : " + movie);
          // System.out.println(movie.getDescription());
          return movie;
     }

     public void deleteMovieById(Long movieId) {
          movieRepository.deleteById(movieId);
     }

     public void addNewMovie(Movie movie) {
          movieRepository.save(movie);
     }
}
