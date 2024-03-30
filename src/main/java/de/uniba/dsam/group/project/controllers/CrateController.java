package de.uniba.dsam.group.project.controllers;

import de.uniba.dsam.group.project.models.Crate;
import de.uniba.dsam.group.project.services.CrateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/crates")

public class CrateController {
    private final CrateService crateService;

    public CrateController(CrateService crateService) {
        this.crateService = crateService;
    }

    @GetMapping
    public String getAllCrates(Model model) {
        List<Crate> crates = crateService.getAllCrates();
        model.addAttribute("crates", crates);
        return "/";
    }
}
