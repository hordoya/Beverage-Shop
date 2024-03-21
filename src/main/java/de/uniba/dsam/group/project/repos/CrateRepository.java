package de.uniba.dsam.group.project.repos;

import de.uniba.dsam.group.project.models.Crate;

import java.util.List;

public interface CrateRepository extends BeverageRepository<Crate>{
    List<Crate> findByBottleId(Long bottleId);
}
