package com.BookMeraShow.BookMeraShow.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "user")
public class User {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "user_id")
     private long id;
     @Column(name = "email")
     private String email;
     @Column(name = "password")
     private String password;
     @Column(name = "user_name")
     private String userName;
     @Column(name = "mobile_no")
     private String mobileNo;
     
     public long getUserId() {
          return id;
     }

     public void setUserId(long userId) {
          this.id = userId;
     }
          
     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }
          
     public String getUserName() {
          return userName;
     }

     public void setUserName(String userName) {
          this.userName = userName;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public String getMobileNo() {
          return mobileNo;
     }

     public void setMobileNo(String mobileNo) {
          this.mobileNo = mobileNo;
     }

     public User(int id, String userName, String mobileNo, String email, String password) {
          this.id = id;
          this.userName = userName;
          this.mobileNo = mobileNo;
          this.email = email;
          this.password = password;
     }

     public User() {
          super();
     }
}
         

