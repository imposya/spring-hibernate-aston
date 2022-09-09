package ru.imposya.task;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.imposya.task.models.Customer;
import ru.imposya.task.models.Employee;
import ru.imposya.task.models.Position;
import ru.imposya.task.models.Project;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Position.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Project.class)
                .addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            //function1
            String HQL = "SELECT e.name, e.age, project.name FROM Employee e LEFT JOIN e.projectList project WHERE e.id=:id";
            Query<Object[]> query = session.createQuery(HQL);
            query.setParameter("id", 5);
            List<Object[]> list = query.list();
            for (Object[] o: list) {
                String name = (String) o[0];
                Integer age = (Integer) o[1];
                String projectName = (String) o[2];
                System.out.println(name + " " + age + " " + projectName);
            }


            /*Project project = session.get(Project.class, 1);
            System.out.println(project.getEmployeeList());*/

            /*Employee employee = new Employee("Vasya", 15, "vasya@mail.ru");
            Employee employee2 = new Employee("Vasyaaa", 16, "vasyan@mail.ru");
            Project project = new Project("Project1", 250000, "PostgreSQL", "Java");
            Project project2 = new Project("Project2", 355000, "PostgreSQL", "Java");

            employee.setProjectList(new ArrayList<>(List.of(project, project2)));
            employee2.setProjectList(new ArrayList<>(List.of(project)));

            project.setEmployeeList(new ArrayList<>(List.of(employee, employee2)));
            project2.setEmployeeList(new ArrayList<>(List.of(employee)));

            session.save(employee);
            session.save(employee2);

            session.save(project);
            session.save(project2);*/

            session.getTransaction().commit();
        }
        finally {
             sessionFactory.close();
        }
    }
}
