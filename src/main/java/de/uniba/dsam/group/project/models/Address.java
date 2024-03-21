package de.uniba.dsam.group.project.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private int number;
    private String postalCode;
    private Long customerId;
    //Address Type: 1 -> Billing, 2 -> Delivery
    private int addressType;

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Address() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public long getCustomer_id() {
        return customerId;
    }

    public void setCustomer_id(Long customerId) {
        this.customerId = customerId;
    }

    public void setAddressType(int addressType) {
        this.addressType = addressType;
    }
}
