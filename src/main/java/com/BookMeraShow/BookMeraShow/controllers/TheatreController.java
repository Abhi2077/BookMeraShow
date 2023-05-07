package com.BookMeraShow.BookMeraShow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BookMeraShow.BookMeraShow.entities.Theatre;
import com.BookMeraShow.BookMeraShow.service.TheatreService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TheatreController {

     @Autowired
     public TheatreService theatreService;

     @PostMapping("/theatre/addNewTheatre")
     public String addNewTheatre(@RequestBody Theatre theatre) {
          try {
               theatreService.addNewTheatre(theatre);
          } catch (Exception e) {
               return "error occured while adding theatre";
          }
          return "theatre added successfully!!";
     }

     @GetMapping("/theatre/getTheatreById/{theatreId}")
     public String getTheatreById(@RequestParam Long theatreId) {
          Theatre theatre = theatreService.getTheatreById(theatreId);
          if (theatre == null)
               return "theatre with given id does not exit!!";

          return theatre.toString();
     }

     @GetMapping("/theatre/getAllTheatres")
     public List<Theatre> getAllTheatres() {
          return theatreService.getAllTheatres();
     }

     @DeleteMapping("/theatre/deleteTheatreById/{theatreId}")
     public String deleteThreatreById(@RequestParam Long theatreId) {
          Theatre theatre = theatreService.getTheatreById(theatreId);
          if(theatre == null)
               return "theatre does not exist!!";
          theatreService.deleteTheatreById(theatreId);
          return "deleted successfully";
     }

}
