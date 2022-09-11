package ru.imposya.task.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.imposya.task.dao.EmployeeDAO;
import ru.imposya.task.models.Employee;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> indexEmployee() {
        return employeeDAO.index();
    }

    public Employee showEmployee(int id) {
        return employeeDAO.show(id);
    }

    public void saveEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    public void updateEmployee(int id, Employee updatedEmployee) {
        employeeDAO.update(id, updatedEmployee);
    }

    public void deleteEmployee(int id) {
        employeeDAO.delete(id);
    }
}
