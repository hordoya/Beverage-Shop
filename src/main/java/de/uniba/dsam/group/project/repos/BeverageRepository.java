package de.uniba.dsam.group.project.repos;

import de.uniba.dsam.group.project.models.Beverage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeverageRepository<T extends Beverage> extends JpaRepository<T, Long> {

}
