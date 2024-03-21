package de.uniba.dsam.group.project.repos;

import de.uniba.dsam.group.project.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
