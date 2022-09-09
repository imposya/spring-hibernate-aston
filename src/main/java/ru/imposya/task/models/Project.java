package ru.imposya.task.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "database")
    private String database;

    @Column(name = "main_language")
    private String mainLanguage;

    @ManyToMany(mappedBy = "projectList")
    private List<Employee> employeeList;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    public Project() {
    }

    public Project(String name, int price, String database, String mainLanguage) {
        this.name = name;
        this.price = price;
        this.database = database;
        this.mainLanguage = mainLanguage;
    }

    public Project(String name, int price, String database, String mainLanguage, Customer customer) {
        this.name = name;
        this.price = price;
        this.database = database;
        this.mainLanguage = mainLanguage;
        this.customer = customer;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getMainLanguage() {
        return mainLanguage;
    }

    public void setMainLanguage(String mainLanguage) {
        this.mainLanguage = mainLanguage;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void addEmployee(Employee employee) {
        if (employeeList == null) {
            employeeList = new ArrayList<>();
        }
        employeeList.add(employee);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", database='" + database + '\'' +
                ", mainLanguage='" + mainLanguage + '\'' +
                '}';
    }
}
