package com.BookMeraShow.BookMeraShow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookMeraShow.BookMeraShow.Entities.Theatre;

@Repository("theatre_repo")
public interface TheatreRepo extends JpaRepository<Theatre, Integer> {
     
}
