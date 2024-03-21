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

//    @GetMapping
//    public ResponseEntity<List<Crate>> getAllCrates(){
//        return new ResponseEntity<>(this.crateService.getAllCrates(), HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Crate> getCrateById(@PathVariable Long id){
        Crate crate = this.crateService.findCrateById(id);
        return (crate != null) ? new ResponseEntity<>(crate, HttpStatus.OK):
                new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping
    public ResponseEntity<String> createCrate(@RequestBody Crate crate){
        this.crateService.createCrate(crate);
        return new ResponseEntity<>("Crate created successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCrateById(@PathVariable Long id){
        boolean didDelete = this.crateService.deleteCrateById(id);
        return didDelete ? new ResponseEntity<>("Crate Deleted successfully!", HttpStatus.OK):
                new ResponseEntity<>("Could not find the id.", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCrate(@RequestBody Crate crate, @PathVariable Long id){
        boolean didUpdate = this.crateService.updateCrate(crate, id);
        return didUpdate ? new ResponseEntity<>("Crate updated successfully!", HttpStatus.OK):
                new ResponseEntity<>("Crate could not be updated.", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/bottles/{bottleId}")
    public ResponseEntity<List<Crate>> findCratesByBottleId(@PathVariable Long bottleId){
        List<Crate> crates = this.crateService.getAllCratesByBottleId(bottleId);
        return (crates != null) ? new ResponseEntity<>(crates, HttpStatus.OK):
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
