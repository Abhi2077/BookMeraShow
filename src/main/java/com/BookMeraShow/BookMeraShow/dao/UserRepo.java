package com.BookMeraShow.BookMeraShow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookMeraShow.BookMeraShow.Entities.User;

@Repository("user_repo")
public interface UserRepo extends JpaRepository<User, Integer> {

}
