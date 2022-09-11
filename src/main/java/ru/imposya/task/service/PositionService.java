package ru.imposya.task.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.imposya.task.dao.PositionDAO;
import ru.imposya.task.models.Position;

@Service
public class PositionService {
    private PositionDAO positionDAO;

    @Autowired
    public PositionService(PositionDAO positionDAO) {
        this.positionDAO = positionDAO;
    }

    public Position showPosition(int id) {
        return positionDAO.show(id);
    }

    public void savePosition(Position position) {
        positionDAO.save(position);
    }

    public void updatePosition(int id, Position updatedPosition) {
        positionDAO.update(id, updatedPosition);
    }

    @Transactional
    public void deletePosition(int id) {
        positionDAO.delete(id);
    }
}
