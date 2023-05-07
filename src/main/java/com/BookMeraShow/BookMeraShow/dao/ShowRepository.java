package com.BookMeraShow.BookMeraShow.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;

import com.BookMeraShow.BookMeraShow.entities.Show;

import jakarta.persistence.LockModeType;

public interface ShowRepository extends CrudRepository<Show, Long> { 

     @Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
     Optional<Show> findWithLockingById(Long id);
}
