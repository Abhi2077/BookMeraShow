package com.BookMeraShow.BookMeraShow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookMeraShow.BookMeraShow.dao.TheatreRepository;
import com.BookMeraShow.BookMeraShow.entities.Theatre;

@Service
public class TheatreService {
     
     @Autowired
     public TheatreRepository theatreRepository;

     public void addNewTheatre(Theatre theatre) {
          theatreRepository.save(theatre);
     }

     public Theatre getTheatreById(Long theatreId) {
          return theatreRepository.getById(theatreId);
     }

     public void deleteTheatreById(Long theatreId) {
          theatreRepository.deleteById(theatreId);
     }

     public List<Theatre> getAllTheatres() {
          List<Theatre> theatreList = (List<Theatre>) theatreRepository.findAll();
          return theatreList;
     }
}
