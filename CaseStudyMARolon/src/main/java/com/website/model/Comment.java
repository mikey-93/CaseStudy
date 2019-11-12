package com.website.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
@Table(name = "COMMENT")
public class Comment {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "Comment_Id")
   private long id;
   
   @NotEmpty
   @Column(name = "Post", nullable = false)
   private String post;
   
   @NotNull
   @Past(message = "Date cannot be in future")
   @Column(name = "Comment_Date", nullable = false)
   private Date date;
   
   @ManyToOne
   @JoinColumn(name = "User_Id", nullable = false)
   private User user;
   
   @ManyToOne
   @JoinColumn(name = "Event_Id", nullable = false)
   private Event event;
   
   public Comment() {
   }
   
   public Comment(String post, Date date, User user, Event event) {
      this.post = post;
      this.date = date;
      this.user = user;
      this.event = event;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getPost() {
      return post;
   }

   public void setPost(String post) {
      this.post = post;
   }

   public Date getDate() {
      return date;
   }

   public void setDate(Date date) {
      this.date = date;
   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

   public Event getEvent() {
      return event;
   }

   public void setEvent(Event event) {
      this.event = event;
   }
}
