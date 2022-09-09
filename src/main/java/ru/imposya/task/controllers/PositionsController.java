package ru.imposya.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.imposya.task.dao.PositionDAO;
import ru.imposya.task.models.Position;

import javax.validation.Valid;

@Controller
@RequestMapping("/positions")
public class PositionsController {

    private final PositionDAO positionDAO;

    @Autowired
    public PositionsController(PositionDAO positionDAO) {
        this.positionDAO = positionDAO;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("position", positionDAO.show(id));
        return "positions/show";
    }

    @GetMapping("/new")
    public String newPosition(@ModelAttribute("position") Position position) {
        return "positions/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("position") @Valid Position position,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "positions/new";

        positionDAO.save(position);
        return "redirect:/positions";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("position", positionDAO.show(id));
        return "positions/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("position") @Valid Position position, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "positions/edit";

        positionDAO.update(id, position);
        return "redirect:/positions";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        positionDAO.delete(id);
        return "redirect:/positions";
    }
}