package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {
   @JsonIgnore

   private int id;

   private String username;

   private String password;
   @JsonIgnore
   private String confirmPassword;
   @JsonIgnore
   private boolean activated;
   private Set<Authority> authorities = new HashSet<>();

   private String role;

   private String firstName;

   private String lastName;

   private String emailAddress;
<<<<<<< HEAD
   @JsonProperty("phone_number")
   private String phoneNumber;
   @JsonProperty("age")
=======

   private String phoneNumber;

>>>>>>> main
   private int age;

   private String emergFirstName;

   private String emergLastName;

   private String emergPhone;

   public User() { }

   public User(int id, String username, String password, String authorities) {
      this.id = id;
      this.username = username;
      this.password = password;
      if(authorities != null) this.setAuthorities(authorities);
      this.activated = true;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public boolean isActivated() {
      return activated;
   }

   public void setActivated(boolean activated) {
      this.activated = activated;
   }

   public Set<Authority> getAuthorities() {
      return authorities;
   }

   public void setAuthorities(Set<Authority> authorities) {
      this.authorities = authorities;
   }

   public void setAuthorities(String authorities) {
      String[] roles = authorities.split(",");
      for(String role : roles) {
         String authority = role.contains("ROLE_") ? role : "ROLE_" + role;
         this.authorities.add(new Authority(authority));
      }
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return id == user.id &&
              activated == user.activated &&
              Objects.equals(username, user.username) &&
              Objects.equals(password, user.password) &&
              Objects.equals(authorities, user.authorities);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, username, password, activated, authorities);
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmailAddress() {
      return emailAddress;
   }

   public void setEmailAddress(String emailAddress) {
      this.emailAddress = emailAddress;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public String getEmergFirstName() {
      return emergFirstName;
   }

   public void setEmergFirstName(String emergencyFirstName) {
      this.emergFirstName = emergencyFirstName;
   }

   public String getEmergLastName() {
      return emergLastName;
   }

   public void setEmergLastName(String emergencyLastName) {
      this.emergLastName = emergencyLastName;
   }

   public String getEmergPhone() {
      return emergPhone;
   }

   public void setEmergPhone(String emergencyPhone) {
      this.emergPhone = emergencyPhone;
   }

   public String getRole() {
      return role;
   }

   public void setRole(String role) {
      this.role = role;
   }

   public String getConfirmPassword() {
      return confirmPassword;
   }

   public void setConfirmPassword(String confirmPassword) {
      this.confirmPassword = confirmPassword;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }


   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", username='" + username + '\'' +
              ", activated=" + activated +
              ", authorities=" + authorities +
              '}';
   }
}
