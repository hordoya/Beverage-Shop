package de.uniba.dsam.group.project.services;

import de.uniba.dsam.group.project.models.Beverage;

public interface BeverageService {
    Object findBeverageById(Long id);

    void saveBeverage(Beverage beverage);
}
