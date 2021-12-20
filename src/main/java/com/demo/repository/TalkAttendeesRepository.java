package com.demo.repository;

import com.demo.models.Attendees;
import com.demo.models.TalkAttendees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalkAttendeesRepository extends JpaRepository<TalkAttendees, Long> {
  TalkAttendees getTalkAttendees(Long id);

}
