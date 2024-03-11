package com.example.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.backend.entity.Project;
import com.example.backend.repository.ProjectRepository;
import com.example.backend.service.ProjectService;

public class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    private Date startDate;
    private Date endDate;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        // Set up start and end dates for testing
        startDate = new Date();
        endDate = new Date(System.currentTimeMillis() + 100000); // Adding 100 seconds for end date
    }

    @Test
    public void testGetAllProjects() {
        // Arrange
        List<Project> projects = new ArrayList<>();
        projects.add(new Project(1L, "Project 1", "Description 1", startDate, endDate));
        projects.add(new Project(2L, "Project 2", "Description 2", startDate, endDate));

        when(projectRepository.findAll()).thenReturn(projects);

        // Act
        List<Project> result = projectService.getAllProjects();

        // Assert
        assertEquals(2, result.size());
    }

    @Test
    public void testGetProjectById() {
        // Arrange
        Project project = new Project(1L, "Project 1", "Description 1", startDate, endDate);
        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));

        // Act
        Optional<Project> result = projectService.getProjectById(1L);

        // Assert
        assertEquals(project, result.orElse(null));
    }

    @Test
    public void testCreateProject() {
        // Arrange
        Project project = new Project(null, "Project 1", "Description 1", startDate, endDate);
        when(projectRepository.save(project)).thenReturn(new Project(1L, "Project 1", "Description 1", startDate, endDate));

        // Act
        Project result = projectService.createProject(project);

        // Assert
        assertEquals("Project 1", result.getName());
    }

    @Test
    public void testUpdateProject() {
        // Arrange
        Project existingProject = new Project(1L, "Project 1", "Description 1", startDate, endDate);
        Project updatedProject = new Project(1L, "Updated Project 1", "Updated Description 1", startDate, endDate);
        when(projectRepository.existsById(1L)).thenReturn(true);
        when(projectRepository.save(updatedProject)).thenReturn(updatedProject);

        // Act
        Project result = projectService.updateProject(1L, updatedProject);

        // Assert
        assertEquals("Updated Project 1", result.getName());
        assertEquals("Updated Description 1", result.getDescription());
    }

    @Test
    public void testDeleteProject() {
        // Arrange
        Long projectId = 1L;
        when(projectRepository.existsById(projectId)).thenReturn(true);

        // Act
        projectService.deleteProject(projectId);

        // Assert
        verify(projectRepository, times(1)).deleteById(projectId);
    }
}