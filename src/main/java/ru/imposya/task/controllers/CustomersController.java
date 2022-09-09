package ru.imposya.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.imposya.task.dao.CustomerDAO;
import ru.imposya.task.models.Customer;

import javax.validation.Valid;

@Controller
@RequestMapping("/customers")
public class CustomersController {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomersController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", customerDAO.show(id));
        return "customers/show";
    }

    @GetMapping("/new")
    public String newCostumer(@ModelAttribute("customer") Customer customer) {
        return "customers/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("customer") @Valid Customer customer,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "customers/new";

        customerDAO.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("customer", customerDAO.show(id));
        return "customers/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("customer") @Valid Customer customer, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "customers/edit";

        customerDAO.update(id, customer);
        return "redirect:/customers";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        customerDAO.delete(id);
        return "redirect:/customers";
    }
}
