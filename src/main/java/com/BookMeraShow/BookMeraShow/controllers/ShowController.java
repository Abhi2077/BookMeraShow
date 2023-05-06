// package com.BookMeraShow.BookMeraShow.controllers;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.BookMeraShow.BookMeraShow.Entities.Show;
// import com.BookMeraShow.BookMeraShow.service.ShowService;

// @RestController
// public class ShowController {
//      @Autowired
//      public ShowService showService;

//      @PostMapping("/show/addShow")
//      public String addNewShow(@RequestBody Show show) {
//           showService.addNewShow(show);
//           return "show added successfully";
//      }

//      @GetMapping("/show/getAllShow")
//      public List<Show> getAllshow() {
//           List<Show> show = showService.getAllShow();
//           return show;
//      }

//      @GetMapping("/show/getShowById/{id}")
//      public Optional<Show> getShowById(@RequestParam int id) {
//           Optional<Show> show = showService.getShowById(id);
//           return show;
//      }

//      @GetMapping("/show/deleteShowById/{id}")
//      public String deleteShowById(@RequestParam int id) {
//           showService.deleteShowById(id);
//           return "show deleted successfully!!";
//      }
// }
