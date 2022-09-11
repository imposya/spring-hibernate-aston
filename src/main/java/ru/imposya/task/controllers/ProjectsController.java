package ru.imposya.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.imposya.task.models.Project;
import ru.imposya.task.service.ProjectService;

import javax.validation.Valid;

@Controller
@RequestMapping("/projects")
public class ProjectsController {

    private ProjectService projectService;

    @Autowired
    public ProjectsController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("project", projectService.showProject(id));
        return "projects/show";
    }

    @GetMapping("/new")
    public String newProject(@ModelAttribute("project") Project project) {
        return "projects/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("project") @Valid Project project,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "projects/new";

        projectService.saveProject(project);
        return "redirect:/projects";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("project", projectService.showProject(id));
        return "projects/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("project") @Valid Project project, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "projects/edit";

        projectService.updateProject(id, project);
        return "redirect:/projects";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        projectService.deleteProject(id);
        return "redirect:/projects";
    }
}
