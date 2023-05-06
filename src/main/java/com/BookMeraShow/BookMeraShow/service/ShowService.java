package com.BookMeraShow.BookMeraShow.service;

// import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookMeraShow.BookMeraShow.Entities.Show;
// import com.BookMeraShow.BookMeraShow.dao.ShowRepo;
import com.BookMeraShow.BookMeraShow.dao.ShowRepo;

@Service("show_service")
public class ShowService {
     
     @Autowired
     public ShowRepo showRepo;
     
     public void addNewShow(Show show) {
          showRepo.save(show);
     }

//      public List<Show> getAllShow() {
//           List<Show> showList = showRepo.findAll();
//           return showList;
//      }

//      public Optional<Show> getShowById(int id) {
//           Optional<Show> show = showRepo.findById(id);
//           return show;
//      }

//      public void deleteShowById(int id) {
//           showRepo.deleteById(id);
//      }
}
