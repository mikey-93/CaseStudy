package com.website.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "User_Id")
   private long id;
   @Column(name = "User_Email", unique = true)
   private String email;
   @Column(name = "User_DOB")
   private Date dateOfBirth;
   @Column(name = "User_Desc")
   private String desc;
   @ManyToMany
   @JoinTable(name = "USER_WRESTLER", 
      joinColumns = @JoinColumn(name = "User_Id"), 
      inverseJoinColumns = @JoinColumn(name = "Wrestler_Id"))
   private Set<Wrestler> wrestlers = new HashSet<>();
   
   public User() {
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
   
   public Date getDateOfBirth() {
      return dateOfBirth;
   }

   public void setDateOfBirth(Date dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
   }

   public String getDesc() {
      return desc;
   }

   public void setDesc(String desc) {
      this.desc = desc;
   }

   public Set<Wrestler> getWrestlers() {
      return wrestlers;
   }

   public void setWrestlers(Set<Wrestler> wrestlers) {
      this.wrestlers = wrestlers;
   }
   
}
