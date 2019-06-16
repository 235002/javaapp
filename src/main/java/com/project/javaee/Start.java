package com.project.javaee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private UserRepository userRepository;
    private ProjectRepository projectRepository;
    private TeamRepository teamRepository;

    @Autowired
    public Start(UserRepository userRepository, ProjectRepository projectRepository, TeamRepository teamRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.teamRepository = teamRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runExample(){
        User user = new User("Lukasz", "Piatek", "piatekmistrz", "tajnehaslo",
                "piatek@gmail.com", "student");
        User user2 = new User("Kamil", "Wojtczak", "kamilskowronek", "jakieshaslo",
                "skowronek@gmail.com", "student");

        userRepository.save(user);
        userRepository.save(user2);

        Project project = new Project("Pong game", "Simply game for android", "",
                "Just basic options", "Create correctly implemented game");
        projectRepository.save(project);

        Team team = new Team("Dariusz's team", 4, project, user, user2);
        teamRepository.save(team);

        Team team2 = new Team("Lukasz's Team", 3);
        teamRepository.save(team2);
        Project project1 = new Project("FTP Client", "", "", "","",
                team2);
        projectRepository.save(project1);

    }
}
