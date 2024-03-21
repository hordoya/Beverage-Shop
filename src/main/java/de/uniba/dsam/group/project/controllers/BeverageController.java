package de.uniba.dsam.group.project.controllers;

import de.uniba.dsam.group.project.models.Beverage;
import de.uniba.dsam.group.project.services.BeverageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beverage")
public class BeverageController {
    private final BeverageService beverageService;

    public BeverageController(BeverageService beverageService) {
        this.beverageService = beverageService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beverage> getBeverageById(@PathVariable Long id){
        Beverage beverage = (Beverage) this.beverageService.findBeverageById(id);
        return (beverage != null) ? new ResponseEntity<>(beverage, HttpStatus.OK):
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
