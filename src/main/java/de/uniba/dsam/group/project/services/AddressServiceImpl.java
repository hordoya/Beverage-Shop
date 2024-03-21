package de.uniba.dsam.group.project.services;

import de.uniba.dsam.group.project.models.Address;
import de.uniba.dsam.group.project.repos.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void createAddress(Address address) {
        this.addressRepository.save(address);
    }

    @Override
    public List<Address> getAllAddresses() {
        return this.addressRepository.findAll();
    }

    @Override
    public List<Address> getAddressesByCustomerIdAndAddressType(Long customerId, int addressType) {
        return this.addressRepository.findAddressByCustomerIdAndAddressType(customerId, addressType);
    }
}
