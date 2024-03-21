package de.uniba.dsam.group.project.services;

import de.uniba.dsam.group.project.models.Address;

import java.util.List;

public interface AddressService {
    void createAddress(Address address);

    List<Address> getAllAddresses();

    List<Address> getAddressesByCustomerIdAndAddressType(Long id, int addressType);
}
