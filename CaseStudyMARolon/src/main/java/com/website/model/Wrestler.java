package com.website.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Past;

@Entity
@Table(name = "WRESTLER")
public class Wrestler {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "Wrest_Id")
   private long id;
   
   @Column(name = "Wrest_Name", length = 50, nullable = false, unique = true)
   private String name;
   
   @Past(message = "Date of birth cannot be in future")
   @Column(name = "Wrest_DOB", nullable = false)
   private Date dateOfBirth;
   
   @Column(name = "Division", length = 50, nullable = false)
   private String division;
   
   @Column(name = "Wrest_Desc")
   private String desc;
   
   @ManyToMany(mappedBy = "wrestlers")
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

   public String getDesc() {
      return desc;
   }

   public void setDesc(String desc) {
      this.desc = desc;
   }

   public Set<Event> getEvents() {
      return events;
   }

   public void setEvents(Set<Event> events) {
      this.events = events;
   }
   
   
}
