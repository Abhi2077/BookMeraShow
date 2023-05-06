package com.BookMeraShow.BookMeraShow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookMeraShow.BookMeraShow.Entities.Theatre;
import com.BookMeraShow.BookMeraShow.dao.TheatreRepo;


@Service("theatre_service")
public class TheatreService {
     @Autowired
     public TheatreRepo theatreRepo;
     
     public void save(Theatre theatre) {
          theatreRepo.save(theatre);
     }

     public void deleteTheatreByID(Integer id) {
          theatreRepo.deleteById(id);
     }

     public Optional<Theatre> getTheatreByID(Integer id) {
          Optional<Theatre> theatre = theatreRepo.findById(id);
          return theatre;
     }

     public List<Theatre> getAllTheatre() {
          List<Theatre> theatreList = theatreRepo.findAll();
          return theatreList; 
     }
}
