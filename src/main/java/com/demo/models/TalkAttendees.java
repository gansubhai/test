package com.demo.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "talks_attendees")
public class TalkAttendees {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private Long talk_id;

  @NotBlank
  private Long attendee_id;

  public TalkAttendees(Long talk_id, Long attendee_id) {
    this.talk_id = talk_id;
    this.attendee_id = attendee_id;

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }



}
