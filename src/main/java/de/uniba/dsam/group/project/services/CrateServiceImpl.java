package de.uniba.dsam.group.project.services;

import de.uniba.dsam.group.project.models.Crate;
import de.uniba.dsam.group.project.repos.CrateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrateServiceImpl implements CrateService {
    private final CrateRepository crateRepository;

    public CrateServiceImpl(CrateRepository crateRepository) {
        this.crateRepository = crateRepository;
    }

    @Override
    public List<Crate> getAllCrates() {
        return crateRepository.findAll();
    }

    @Override
    public void createCrate(Crate crate) {
        this.crateRepository.save(crate);
    }

    @Override
    public Crate findCrateById(Long id) {
        return this.crateRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteCrateById(Long id) {
        if (crateRepository.existsById(id)){
            crateRepository.deleteById(id);
            return true;
        } else{
            return false;
        }
    }

    @Override
    public Boolean updateCrate(Crate updatedCrate, Long id) {
        Optional<Crate> crateOptional = crateRepository.findById(id);
        if (crateOptional.isPresent()) {
            Crate crate = crateOptional.get();
            crate.setName(updatedCrate.getName());
            crate.setPicture(updatedCrate.getPicture());
            crate.setNoOfBottles(updatedCrate.getNoOfBottles());
            crate.setBottleId(updatedCrate.getBottleId());
            crate.setInStock(updatedCrate.getInStock());
            crateRepository.save(crate);
            return true;
        }
        return false;
    }

    @Override
    public List<Crate> getAllCratesByBottleId(Long bottleId) {
        return this.crateRepository.findByBottleId(bottleId);
    }
}
