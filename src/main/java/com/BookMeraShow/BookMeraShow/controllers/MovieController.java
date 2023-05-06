package com.BookMeraShow.BookMeraShow.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BookMeraShow.BookMeraShow.Entities.Movie;
import com.BookMeraShow.BookMeraShow.service.MovieService;

@RestController
public class MovieController {
     
     @Autowired
     public MovieService movieServie;


     @PostMapping("/movie/addNewMovie")
     public String AddNewMovie(@RequestBody Movie movie) {
          movieServie.save(movie);
          return "new movie added";
     }

     @GetMapping("/movie/getMovieById/{id}")
     public Optional<Movie> getMovieById(@RequestParam long id) {
          Optional<Movie> movie = null;
          movie = movieServie.getMovieByID(id);
          return movie;
     }

     @GetMapping("/movie/getAllMovies")
     public List<Movie> getAllMovies() {
          List<Movie> movies = movieServie.getAllMovies();
          return movies;
     }

     @GetMapping("/movie/deleteMovieById/{id}")
     public String deleteMovieById(@RequestParam long id) {
          movieServie.deleteMovieByID(id);
         return "movie deleted successfully!!";
     }
     
}
