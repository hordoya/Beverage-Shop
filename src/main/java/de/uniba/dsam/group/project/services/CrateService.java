package de.uniba.dsam.group.project.services;

import de.uniba.dsam.group.project.models.Crate;

import java.util.List;

public interface CrateService {
    List<Crate> getAllCrates();
    void createCrate(Crate crate);
    Crate findCrateById(Long id);
    Boolean deleteCrateById(Long id);
    Boolean updateCrate(Crate crate, Long id);
    List<Crate> getAllCratesByBottleId(Long bottleId);
}
