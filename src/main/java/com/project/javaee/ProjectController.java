package com.project.javaee;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProjectController {
    ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/projects")
    public Iterable<Project> getAll(){
        return projectRepository.findAll();
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<Project> projects = projectRepository.findById(id);

        return projects.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/project")
    public boolean createProject(@RequestBody Project newProject){
        projectRepository.save(newProject);
        return true;
    }

    @PutMapping("/project")
    public boolean updateProject(@RequestBody Project updated){
        projectRepository.save(updated);
        return true;
    }

    @DeleteMapping("/project/{id}")
    public void deleteProject(@PathVariable Long id){
        projectRepository.deleteById(id);
    }
}
