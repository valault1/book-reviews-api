package ault.BookReviews.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ault.BookReviews.models.Project;
import ault.BookReviews.services.ProjectService;

@CrossOrigin(origins = "*")
@RestController
public class ProjectController {
  private final ProjectService projectService;

  @Autowired
  public ProjectController(ProjectService projectService) {
    this.projectService = projectService;
  }

  @GetMapping("/project/count")
  public long projectCount() {
    return projectService.projectCount();
  }

  @GetMapping("/project/projects")
  public List<Project> projects() {
    return projectService.projects();
  }

  @PutMapping("/project")
  public String createProject(@RequestBody Project newProject) {
    return projectService.createProject(newProject);
  }

  @PostMapping("/project")
  public String updateProject(@RequestBody Project updatedProject) {
    return projectService.updateProject(updatedProject);
  }

}