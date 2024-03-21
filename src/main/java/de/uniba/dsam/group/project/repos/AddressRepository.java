package de.uniba.dsam.group.project.repos;

import de.uniba.dsam.group.project.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAddressByCustomerIdAndAddressType(Long customerId, int AddressType);
}