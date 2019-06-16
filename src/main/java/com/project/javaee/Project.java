package com.project.javaee;

import javax.persistence.*;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String shortDescription;
    private String longDescription;
    private String scope;
    private String goals;

    @JoinColumn
    @OneToOne(cascade = CascadeType.MERGE)
    private Team team;

    public Project() {
    }

    public Project(String name, String shortDescription, String longDescription, String scope, String goals) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.scope = scope;
        this.goals = goals;
    }

    public Project(String name, String shortDescription, String longDescription, String scope, String goals, Team team) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.scope = scope;
        this.goals = goals;
        this.team = team;
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", scope='" + scope + '\'' +
                ", goals='" + goals + '\'' +
                ", team=" + team +
                '}';
    }
}
