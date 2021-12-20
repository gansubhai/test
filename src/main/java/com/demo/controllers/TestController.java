package com.demo.controllers;

import com.demo.models.Attendees;
import com.demo.models.TalkAttendees;
import com.demo.models.Talks;
import com.demo.models.User;
import com.demo.repository.AttendeesRepository;
import com.demo.repository.TalkAttendeesRepository;
import com.demo.repository.TalksRepository;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    TalksRepository talksRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AttendeesRepository attendeesRepository;

    @Autowired
    TalkAttendeesRepository talkAttendeesRepository;


    @PostMapping("/talksto")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Talks> createTalks(@RequestBody Talks talks) {
        Talks _talks = talksRepository.save(new Talks(talks.getTitle(), talks.getRoom(), getAttendeeid(talks.getSpeakerName())));
        return new ResponseEntity<>(_talks, HttpStatus.CREATED);
    }

    @PostMapping("/attendees")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> createAttendes(@RequestBody List<Attendees> attendees) {
        attendees.forEach(attendee -> {
            attendeesRepository.save(new Attendees(attendee.getName(), attendee.getEmail(), attendee.getCompany(), attendee.getBio()));
        });
        return new ResponseEntity<>("DONE", HttpStatus.CREATED);
    }

    @PutMapping("/talks/{talk_id}/attendees/{attendee_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> updateTalksAttendee(@PathVariable("talk_title") String talk_title, @PathVariable("attendee_name") String attendee_name) {
        TalkAttendees _talkAttendees = talkAttendeesRepository.save(new TalkAttendees(getTalkid(talk_title), getAttendeeid(attendee_name)));


        return new ResponseEntity<>("OK", HttpStatus.OK);
    }


    private Long getTalkid(String title){
        Talks talks = talksRepository.getTalkIdFromTitle(title);
        if(null!=talks){return talks.getTalk_id();} else {new Exception("Talks not Found");}
        return  null;
    }

    private Long getAttendeeid(String name){
        Attendees attendees = attendeesRepository.getAttendeesIdFromUserName(name);
        if(null!=attendees){return attendees.getAttendee_id();} else {new Exception("attendees not Found");}
        return  null;
    }
}
