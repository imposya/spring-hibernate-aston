package ru.imposya.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.imposya.task.dao.EmployeeDAO;
import ru.imposya.task.models.Employee;

import javax.validation.Valid;


@Controller
@RequestMapping("/employees")
public class EmployeesController {

}
