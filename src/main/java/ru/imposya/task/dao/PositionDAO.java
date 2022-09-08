package ru.imposya.task.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.imposya.task.models.Position;

import java.util.List;

@Component
public class PositionDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public PositionDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public Position show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Position.class, id);
    }

    @Transactional
    public void save(Position position) {
        Session session = sessionFactory.getCurrentSession();
        session.save(position);
    }

    @Transactional
    public void update(int id, Position updatedPosition) {
        Session session = sessionFactory.getCurrentSession();
        Position positionToBeUpdated = session.get(Position.class, id);

        positionToBeUpdated.setName(updatedPosition.getName());
        positionToBeUpdated.setSalary(updatedPosition.getSalary());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Position.class, id));
    }
}
