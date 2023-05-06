package com.BookMeraShow.BookMeraShow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookMeraShow.BookMeraShow.Entities.Movie;

@Repository("movie_repo")
public interface MovieRepo extends JpaRepository<Movie, Long> {

}