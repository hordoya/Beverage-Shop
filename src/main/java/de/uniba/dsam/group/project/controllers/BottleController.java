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


//    @GetMapping
//    public ResponseEntity<List<Bottle>> findAll() {
//        return new ResponseEntity<>(this.bottleService.findAll(), HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<String> createBottles(@RequestBody Bottle bottle) {
        this.bottleService.createBottle(bottle);
        return new ResponseEntity<>("Bottle added successfully.", HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Bottle> getBottleById(@PathVariable Long id) {
        Bottle bottle = this.bottleService.getBottleById(id);
        return bottle != null ? new ResponseEntity<>(bottle, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<String> deleteBottle(@PathVariable Long id) {
        boolean didDelete = this.bottleService.deleteBottleById(id);
        return didDelete ? new ResponseEntity<>("Bottle deleted successfully.", HttpStatus.OK) :
                new ResponseEntity<>("The bottle with this id does not exist", HttpStatus.NOT_FOUND);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<String> updateBottle(@PathVariable Long id, @RequestBody Bottle updatedBottle) {
        boolean didUpdate = this.bottleService.updateBottleById(id, updatedBottle);
        return didUpdate ? new ResponseEntity<>("Object updated successfully!", HttpStatus.OK) :
                new ResponseEntity<>("Could not update the Bottles. Please try again!", HttpStatus.NOT_ACCEPTABLE);
    }
}
