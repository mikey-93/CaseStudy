package com.website.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "WRESTLER")
public class Wrestler {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "Wrest_Id")
   private long id;
   @Column(name = "Wrest_Name", nullable = false, unique = true)
   private String name;
   @Column(name = "Wrest_DOB", nullable = false)
   private Date dateOfBirth;
   @Column(name = "Division", nullable = false)
   private String division;
   @Column(name = "Wrest_Desc")
   private String desc;
   @ManyToMany(mappedBy = "wrestlers", cascade = CascadeType.PERSIST)
   private Set<Event> events = new HashSet<>();
   
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
