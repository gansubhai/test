package com.demo.repository;

import com.demo.models.Attendees;
import com.demo.models.Talks;
import com.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttendeesRepository extends JpaRepository<Attendees, Long> {
  Attendees getAttendees(Long attendee_id);

  Attendees getAttendeesIdFromUserName(String name);
}
