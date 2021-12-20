package com.demo.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "talks", uniqueConstraints = {
        @UniqueConstraint(columnNames = "title")
})
public class Talks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long talk_id;

    @NotBlank
    @Size(max = 500)
    private String title;

    @NotBlank
    @Size(max = 500)
    private String room;

    @NotBlank
    private Long speakerId;

    @OneToMany(mappedBy = "talk_id")
    private Set<TalkAttendees> talkAttendees;

    @Transient
    private String speakerName;

    public Talks() {
    }

    public Talks(String title, String room, Long speakerId) {
        this.title = title;
        this.room = room;
        this.speakerId = speakerId;
    }

    public Long getTalk_id() {
        return talk_id;
    }

    public void setTalk_id(Long talk_id) {
        this.talk_id = talk_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Long getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(Long speakerId) {
        this.speakerId = speakerId;
    }

    public Set<TalkAttendees> getTalkAttendees() {
        return talkAttendees;
    }

    public void setTalkAttendees(Set<TalkAttendees> talkAttendees) {
        this.talkAttendees = talkAttendees;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }
}
