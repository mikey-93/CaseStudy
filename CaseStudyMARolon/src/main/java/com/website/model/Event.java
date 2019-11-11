package com.website.model;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Past;

@Entity
@Table(name = "EVENT")
public class Event {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "Event_Id")
   private long id;
   
   @Column(name = "Event_Name", nullable = false, unique = true)
   private String name;
   
   @Past(message = "Date cannot be in future")
   @Column(name = "Event_Date", nullable = false)
   private Date date;
   
   @Column(name = "City", nullable = false)
   private String city;
   
   @Column(name = "State", nullable = false)
   private String state;
   
   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(name = "EVENT_WRESTLER", 
      joinColumns = @JoinColumn(name = "Event_Id"), 
      inverseJoinColumns = @JoinColumn(name = "Wrestler_Id"))
   private Set<Wrestler> wrestlers = new HashSet<>();
   
   @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @OrderBy("date")
   private Set<Comment> comments = new LinkedHashSet<>();
   
   public Event() {
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

   public Date getDate() {
      return date;
   }

   public void setDate(Date date) {
      this.date = date;
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

   public Set<Comment> getComments() {
      return comments;
   }

   public void setComments(Set<Comment> comments) {
      this.comments = comments;
   }
   
}
