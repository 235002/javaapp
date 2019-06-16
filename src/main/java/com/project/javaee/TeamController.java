package com.project.javaee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TeamController {
    TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping("/teams")
    public Iterable<Team> getAll(){
        return teamRepository.findAll();
    }

    @GetMapping("/team/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<Team> teams = teamRepository.findById(id);

        return teams.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/team")
    public boolean createTeam(@RequestBody Team newTeam){
        teamRepository.save(newTeam);
        return true;
    }

    @PutMapping("/team")
    public boolean updateTeam(@RequestBody Team updated){
        teamRepository.save(updated);
        return true;
    }

    @DeleteMapping("/team/{id}")
    public void deleteTeam(@PathVariable Long id){
        teamRepository.deleteById(id);
    }

}
