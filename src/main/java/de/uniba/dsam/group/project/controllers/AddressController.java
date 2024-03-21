package de.uniba.dsam.group.project.controllers;

import de.uniba.dsam.group.project.models.Address;
import de.uniba.dsam.group.project.services.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAllAddresess(){
        return this.addressService.getAllAddresses();
    }

    @PostMapping
    public ResponseEntity<String> createAddress(@RequestBody Address address){
        this.addressService.createAddress(address);
        return new ResponseEntity<>("Address added Successfully.", HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}/billing-addresses")
    public ResponseEntity<List<Address>> getBillingAddressesByCustomerId(@PathVariable Long customerId){
        List<Address> addresses = this.addressService.getAddressesByCustomerIdAndAddressType(customerId, 1);
        return (addresses != null) ? new ResponseEntity<>(addresses, HttpStatus.OK) :
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/customer/{customerId}/delivery-addresses")
    public ResponseEntity<List<Address>> getDeliveryAddressesByCustomerId(@PathVariable Long customerId){
        List<Address> addresses = this.addressService.getAddressesByCustomerIdAndAddressType(customerId, 2);
        return (addresses != null) ? new ResponseEntity<>(addresses, HttpStatus.OK) :
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
