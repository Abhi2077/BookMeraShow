package com.BookMeraShow.BookMeraShow.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.BookMeraShow.BookMeraShow.entities.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {

     @Query(nativeQuery = true, value = "select * from movies m where m.movie_id = :movieId")
     public Movie getById(Long movieId);
}
