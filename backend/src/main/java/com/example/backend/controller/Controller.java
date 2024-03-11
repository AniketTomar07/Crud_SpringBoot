package com.example.backend.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.Project;
import com.example.backend.exception.ProjectNotFoundException;
import com.example.backend.repository.ProjectRepository;
import com.example.backend.service.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/projects")
public class Controller {
	 @Autowired
	    private ProjectService projectService;
	 @Autowired
	 private ProjectRepository projectRepository;

	    @GetMapping
	    public List<Project> getAllProjects() {
	        return projectService.getAllProjects();
	    }

	    public Project getProjectById(Long id) {
	        return projectRepository.findById(id)
	                                 .orElseThrow(() -> new ProjectNotFoundException("Project not found with id: " + id));
	    }
	    @PostMapping
	    public ResponseEntity<Project> createProject(@Valid @RequestBody Project project) {
	        Project createdProject = projectService.createProject(project);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdProject);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Project> updateProject(@PathVariable Long id, @Valid @RequestBody Project project) {
	        Project updatedProject = projectService.updateProject(id, project);
	        return ResponseEntity.ok(updatedProject);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
	        projectService.deleteProject(id);
	        return ResponseEntity.noContent().build();
	    }


}
