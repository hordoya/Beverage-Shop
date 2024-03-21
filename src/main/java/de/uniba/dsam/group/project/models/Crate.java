package de.uniba.dsam.group.project.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Setter
public class Crate extends Beverage {
    private int noOfBottles;
    private Long bottleId;


    public Crate() {

    }

    public void setNoOfBottles(int noOfBottles) {
        this.noOfBottles = noOfBottles;
    }

    public void setBottleId(Long bottleId) {
        this.bottleId = bottleId;
    }
}
