package ru.imposya.task.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.imposya.task.models.Customer;

@Component
public class CustomerDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public CustomerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public Customer show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Transactional
    public void save(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(customer);
    }

    @Transactional
    public void update(int id, Customer updatedCustomer) {
        Session session = sessionFactory.getCurrentSession();
        Customer customerToBeUpdated = session.get(Customer.class, id);

        customerToBeUpdated.setName(updatedCustomer.getName());
        customerToBeUpdated.setCountry(updatedCustomer.getCountry());
        customerToBeUpdated.setEmail(updatedCustomer.getEmail());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Customer.class, id));
    }
}
