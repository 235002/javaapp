package com.project.javaee;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int attendeesLimit;

    @OneToMany(mappedBy = "team", cascade = CascadeType.MERGE)
    private Set<User> attendees;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn
    private Project project;

    public Team() {
    }

    public Team(String name, int attendeesLimit) {
        this.name = name;
        this.attendeesLimit = attendeesLimit;
    }

    public Team(String name, int attendeesLimit,  Project project, User... attendees) {
        this.name = name;
        this.attendeesLimit = attendeesLimit;
        this.project = project;
        this.attendees = Stream.of(attendees).collect(Collectors.toSet());
        this.attendees.forEach(x -> x.setTeam(this));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttendeesLimit() {
        return attendeesLimit;
    }

    public void setAttendeesLimit(int attendeesLimit) {
        this.attendeesLimit = attendeesLimit;
    }

    public Set<User> getAttendees() {
        return attendees;
    }

    public void setAttendees(Set<User> attendees) {
        this.attendees = attendees;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", attendeesLimit=" + attendeesLimit +
                ", attendee=" + attendees +
                ", project=" + project +
                '}';
    }
}


