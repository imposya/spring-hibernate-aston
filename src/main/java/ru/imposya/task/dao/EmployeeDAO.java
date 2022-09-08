package ru.imposya.task.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.imposya.task.models.Employee;

import java.util.List;


@Component
public class EmployeeDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Employee> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from Employee p", Employee.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Employee show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Transactional
    public void save(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
    }

    @Transactional
    public void update(int id, Employee updatedEmployee) {
        Session session = sessionFactory.getCurrentSession();
        Employee employeeToBeUpdated = session.get(Employee.class, id);

        employeeToBeUpdated.setName(updatedEmployee.getName());
        employeeToBeUpdated.setAge(updatedEmployee.getAge());
        employeeToBeUpdated.setEmail(updatedEmployee.getEmail());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Employee.class, id));
    }
}
