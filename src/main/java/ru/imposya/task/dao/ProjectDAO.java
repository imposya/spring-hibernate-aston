package ru.imposya.task.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.imposya.task.models.Project;

@Component
public class ProjectDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public ProjectDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public Project show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Project.class, id);
    }
    @Transactional
    public void save(Project project) {
        Session session = sessionFactory.getCurrentSession();
        session.save(project);
    }

    @Transactional
    public void update(int id, Project updatedProject) {
        Session session = sessionFactory.getCurrentSession();
        Project projectToBeUpdated = session.get(Project.class, id);

        projectToBeUpdated.setName(updatedProject.getName());
        projectToBeUpdated.setPrice(updatedProject.getPrice());
        projectToBeUpdated.setDatabase(updatedProject.getDatabase());
        projectToBeUpdated.setMainLanguage(updatedProject.getMainLanguage());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Project.class, id));
    }
}
