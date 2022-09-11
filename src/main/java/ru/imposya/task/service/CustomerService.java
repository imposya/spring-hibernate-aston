package ru.imposya.task.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.imposya.task.dao.CustomerDAO;
import ru.imposya.task.models.Customer;

@Service
public class CustomerService {
    private CustomerDAO customerDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public Customer showCustomer(int id) {
        return customerDAO.show(id);
    }

    public void saveCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    public void updateCustomer(int id, Customer updatedCustomer) {
        customerDAO.update(id, updatedCustomer);
    }

    public void deleteCustomer(int id) {
        customerDAO.delete(id);
    }
}
