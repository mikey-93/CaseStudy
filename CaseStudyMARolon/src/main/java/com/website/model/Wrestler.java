package com.website.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "WRESTLER")
public class Wrestler {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "Wrestler_Id")
   private long id;
   
   @NotEmpty(message = "required, cannot be empty")
   @Column(name = "NAME")
   private String name;
   
   private Date dateOfBirth;
   
   private String division;
   
   public Wrestler() {
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Date getDateOfBirth() {
      return dateOfBirth;
   }

   public void setDateOfBirth(Date dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
   }

   public String getDivision() {
      return division;
   }

   public void setDivision(String division) {
      this.division = division;
   }
   
   
}
