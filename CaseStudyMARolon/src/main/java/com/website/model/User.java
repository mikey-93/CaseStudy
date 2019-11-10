package com.website.model;

import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.website.model.Authorities;

@Entity
@Table(name = "USER")
public class User {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "User_Id")
   private long id;
   
   @NotEmpty
   @Column(name = "Username", nullable = false, unique = true)
   private String username;
   
   @NotEmpty
   @Email
   @Column(name = "User_Email", nullable = false, unique = true)
   private String email;
   
   @NotEmpty
   @Column(name = "User_Password", nullable = false)
   private String password;
   
   @NotNull(message = "must not be empty")
   @Past(message = "Date of birth cannot be in future")
   @Column(name = "User_DOB", nullable = false)
   private Date dateOfBirth;
   
   @Column(name = "User_Desc")
   private String desc;
   
   @ManyToMany
   @JoinTable(name = "USER_WRESTLER", 
      joinColumns = @JoinColumn(name = "User_Id"), 
      inverseJoinColumns = @JoinColumn(name = "Wrestler_Id"))
   private Set<Wrestler> wrestlers = new HashSet<>();
   
   //Spring Security
   @Column(name = "enabled", nullable = false)
   private boolean enabled;
   
   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private Set<Authorities> authorities = new HashSet<>();
   
   public User() {
   }

   public User(String username, String email, String password, Date dateOfBirth, String desc) {
      this.username = username;
      this.email = email;
      this.password = password;
      this.dateOfBirth = dateOfBirth;
      this.desc = desc;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
   
   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
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
   
   //Spring Security
   public boolean isEnabled() {
      return enabled;
   }

   public void setEnabled(boolean enabled) {
      this.enabled = enabled;
   }

   public Set<Authorities> getAuthorities() {
      return authorities;
   }

   public void setAuthorities(Set<Authorities> authorities) {
      this.authorities = authorities;
   }
}
