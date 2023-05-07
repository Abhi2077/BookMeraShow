package com.BookMeraShow.BookMeraShow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookMeraShow.BookMeraShow.dao.ShowRepository;
import com.BookMeraShow.BookMeraShow.entities.Show;

@Service
public class ShowService {
     
     @Autowired
     public ShowRepository showRepository;

     public void addNewShow(Show show) {
          showRepository.save(show);
     }

     public List<Show> getAllShow() {
          return (List<Show>) showRepository.findAll();
     }

     public void deleteShowById(Long showId) {
          showRepository.deleteById(showId);
     }

     public Show getShowById(Long showId) {
          return showRepository.getShowById(showId);
     }
}
