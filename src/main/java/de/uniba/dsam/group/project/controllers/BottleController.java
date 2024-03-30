package de.uniba.dsam.group.project.controllers;

import de.uniba.dsam.group.project.models.Bottle;
import de.uniba.dsam.group.project.services.BottleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bottles")
public class BottleController {
    private final BottleService bottleService;

    public BottleController(BottleService bottleService) {
        this.bottleService = bottleService;
    }

    @GetMapping
    public String findAll(Model model) {
        List<Bottle> bottles = bottleService.findAll();

        model.addAttribute("bottles", bottles);
        return "home";
    }
}
