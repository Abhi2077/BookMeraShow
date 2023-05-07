package com.BookMeraShow.BookMeraShow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BookMeraShow.BookMeraShow.entities.Movie;
import com.BookMeraShow.BookMeraShow.service.MovieService;

@RestController
public class MovieController {
     
     @Autowired
     public MovieService movieService;

     @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
     @GetMapping("/movie/getAllMovies")
     public List<Movie> getAllMovies() {
          List<Movie> movieList = movieService.getAllMovies();
          return movieList;
     }

     @PreAuthorize("hasRole('ADMIN')")
     @PostMapping("/movie/addNewMovie")
     public String addNewMovie(@RequestBody Movie movie) {
          try {
               System.out.println(movie.getMovieName());
               movieService.addNewMovie(movie);
          } catch (Exception e) {
               return "movie could not be added error occured";
          }
          return "success movie added";
     }

     @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
     @GetMapping("/movie/getMovieById/{movieId}")
     public String getMovieById(@RequestParam Long movieId) {
          Movie movie = movieService.getMovieById(movieId);
          if(movie == null)
               return "No movie found with give id";
          return movie.toString();
     }

     @PreAuthorize("hasRole('ADMIN')")
     @DeleteMapping("/movie/deleteMovieById/{movieId}")
     public String deleteMovieById(Long movieId) {
          if(movieService.getMovieById(movieId) == null)
               return "no movie present with given id";
          else 
               movieService.deleteMovieById(movieId);
          return "movie deleted";
     }
}
