package de.uniba.dsam.group.project.repos;

import de.uniba.dsam.group.project.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItem, Long> {

}

