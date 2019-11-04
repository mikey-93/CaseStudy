package com.website.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EVENT")
public class Event {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "Event_Id")
   private long id;
   @Column(name = "City")
   private String city;
   @Column(name = "State")
   private String state;
   @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinTable(name = "EVENT_WRESTLER", 
      joinColumns = @JoinColumn(name = "Event_Id"), 
      inverseJoinColumns = @JoinColumn(name = "Wrestler_Id"))
   private Set<Wrestler> wrestlers = new HashSet<>();
   
   public Event() {
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public Set<Wrestler> getWrestlers() {
      return wrestlers;
   }

   public void setWrestlers(Set<Wrestler> wrestlers) {
      this.wrestlers = wrestlers;
   }
   
}
