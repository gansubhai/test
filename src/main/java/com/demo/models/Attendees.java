package com.demo.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "attendees")
public class Attendees {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long attendee_id;

  @NotBlank
  @Size(max = 50)
  private String name;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 50)
  private String company;

  @NotBlank
  @Size(max = 500)
  private String bio;

  @OneToMany(mappedBy = "attendee_id")
  private Set<TalkAttendees> talkAttendees ;

  public Attendees() {
  }

  public Attendees(String name,String email, String company, String bio) {
    this.name = name;
    this.email = email;
    this.company = company;
    this.bio = bio;
  }

  public Long getAttendee_id() {
    return attendee_id;
  }

  public void setAttendee_id(Long attendee_id) {
    this.attendee_id = attendee_id;
  }

  public Set<TalkAttendees> getTalkAttendees() {
    return talkAttendees;
  }

  public void setTalkAttendees(Set<TalkAttendees> talkAttendees) {
    this.talkAttendees = talkAttendees;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }
}
