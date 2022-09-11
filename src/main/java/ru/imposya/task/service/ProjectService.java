package ru.imposya.task.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.imposya.task.dao.ProjectDAO;
import ru.imposya.task.models.Project;

@Service
public class ProjectService {
    private ProjectDAO projectDAO;

    @Autowired
    public ProjectService(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    public Project showProject(int id) {
        return projectDAO.show(id);
    }

    public void saveProject(Project project) {
        projectDAO.save(project);
    }

    public void updateProject(int id, Project updatedProject) {
        projectDAO.update(id, updatedProject);
    }

    public void deleteProject(int id) {
        projectDAO.delete(id);
    }
}
