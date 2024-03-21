package de.uniba.dsam.group.project.services;

import de.uniba.dsam.group.project.models.Beverage;
import de.uniba.dsam.group.project.repos.BeverageRepository;
import org.springframework.stereotype.Service;

@Service
public class BeverageServiceImpl implements BeverageService {
    private final BeverageRepository<Beverage> beverageRepository;
    public BeverageServiceImpl(BeverageRepository<Beverage> beverageRepository) {
        this.beverageRepository = beverageRepository;
    }

    @Override
    public Beverage findBeverageById(Long id){
        return this.beverageRepository.findById(id).orElse(null);
    }

    @Override
    public void saveBeverage(Beverage beverage) {
        this.beverageRepository.save(beverage);
    }
}
