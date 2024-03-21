package de.uniba.dsam.group.project.services;

import de.uniba.dsam.group.project.models.Bottle;

import java.util.List;

public interface BottleService {
    List<Bottle> findAll();

    void createBottle(Bottle bottle);

    Bottle getBottleById(Long id);

    boolean deleteBottleById(Long id);

    boolean updateBottleById(Long id, Bottle updatedBottle);
}

