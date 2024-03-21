package de.uniba.dsam.group.project.services;

import de.uniba.dsam.group.project.models.Bottle;
import de.uniba.dsam.group.project.repos.BottleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BottleServiceImpl implements BottleService {
    private final BottleRepository bottleRepository;

    @Autowired
    public BottleServiceImpl(BottleRepository bottleRepository) {
        this.bottleRepository = bottleRepository;
    }

    public List<Bottle> findAll() {
        return this.bottleRepository.findAll();
    }

    public void createBottle(Bottle bottle) {
        this.bottleRepository.save(bottle);
    }

    public Bottle getBottleById(Long id) {
        return this.bottleRepository.findById(id).orElse(null);
    }

    public boolean deleteBottleById(Long id) {
        if (this.bottleRepository.existsById(id)){
            this.bottleRepository.deleteById(id);
            return true;
        } else{
            return false;
        }
    }

    public boolean updateBottleById(Long id, Bottle updatedBottle) {
        Optional<Bottle> bottleOptional = bottleRepository.findById(id);
        System.out.println(bottleOptional);
        if (bottleOptional.isPresent()) {
            Bottle bottle = bottleOptional.get();
            bottle.setName(updatedBottle.getName());
            bottle.setPicture(updatedBottle.getPicture());
            bottle.setVolume(updatedBottle.getVolume());
            bottle.setIsAlcoholic(updatedBottle.getIsAlcoholic());
            bottle.setVolumePercent(updatedBottle.getVolumePercent());
            bottle.setPrice(updatedBottle.getPrice());
            bottle.setSupplier(updatedBottle.getSupplier());
            bottle.setInStock(updatedBottle.getInStock());
            bottleRepository.save(bottle);
            return true;
        }
        return false;
    }
}
