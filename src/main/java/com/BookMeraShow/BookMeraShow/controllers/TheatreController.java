package com.BookMeraShow.BookMeraShow.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BookMeraShow.BookMeraShow.Entities.Theatre;
import com.BookMeraShow.BookMeraShow.service.TheatreService;


@RestController
public class TheatreController {
     @Autowired
     public TheatreService theatreService;
     
     @PostMapping("/theatre/addNewTheatre")
     public String addNewTheatre(@RequestBody Theatre theatre) {

          theatreService.save(theatre);
          return "success theatre added!!";
     }

     @GetMapping("/theatre/deleteTheatre/{id}")
     public String deleteTheatre(@RequestParam Integer id) {
          theatreService.deleteTheatreByID(id);
          return "theatre deleted";
     }

     @GetMapping("/theatre/getTheatreById/{id}")
     public Optional<Theatre> getTheatreByID(@RequestParam Integer id) {
          Optional<Theatre> theatre = theatreService.getTheatreByID(id);
          return theatre;
     }

     @GetMapping("/theatre/getAllTheatre")
     public List<Theatre> getAllTheatre() {
          List<Theatre> theatreList = theatreService.getAllTheatre();
          return theatreList;
     }
}
