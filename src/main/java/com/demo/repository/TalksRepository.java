package com.demo.repository;

import com.demo.models.TalkAttendees;
import com.demo.models.Talks;
import com.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TalksRepository extends JpaRepository<Talks, Long> {

  Talks getTalks(Long talk_id);
  Talks getTalkIdFromTitle(String title);
}
