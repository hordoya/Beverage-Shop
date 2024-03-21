package de.uniba.dsam.group.project.Demo;

import de.uniba.dsam.group.project.models.Bottle;
import de.uniba.dsam.group.project.models.Crate;
import de.uniba.dsam.group.project.repos.BottleRepository;
import de.uniba.dsam.group.project.repos.CrateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoData {
    @Autowired
    private BottleRepository bottleRepository;
    @Autowired
    private CrateRepository crateRepository;



    /**
     * We create some demo data here, when the database schema is created and the app is ready.
     *
     * @param event
     */
    @EventListener
    public void createDemoData(ApplicationReadyEvent event) {

        if (bottleRepository.count() == 0) {
            // Add demo data for Bottle
            Bottle bottle1 = new Bottle();
            bottle1.setName("Whiskey");
            bottle1.setPicture("https://media.gettyimages.com/id/157674223/de/foto/whisky-bourbon-kentucky.jpg?s=2048x2048&w=gi&k=20&c=3K2KWWb0X3i-EVvP4wyHFZ7lgUEWlU0NqWa_5x44edQ=");
            bottle1.setPrice(29.99);
            bottle1.setInStock(100L);
            bottle1.setBottle(true);
            bottle1.setVolume(750.0);
            bottle1.setIsAlcoholic(true);
            bottle1.setVolumePercent(40.0);
            bottle1.setSupplier("XYZ Beverages");

            Bottle bottle2 = new Bottle();
            bottle2.setName("Vodka");
            bottle2.setPicture("https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/Smirnoff_Red_Label_8213.jpg/200px-Smirnoff_Red_Label_8213.jpg");
            bottle2.setPrice(19.99);
            bottle2.setInStock(150L);
            bottle2.setBottle(true);
            bottle2.setVolume(700.0);
            bottle2.setIsAlcoholic(true);
            bottle2.setVolumePercent(355.0);
            bottle2.setSupplier("ABC Spirits");

            // Save the demo data
            bottleRepository.save(bottle1);
            bottleRepository.save(bottle2);
        }
        if (crateRepository.count() == 0) {
            // Add demo data for Bottle
            Crate crate1 = new Crate();
            crate1.setName("Whiskey Crate");
            crate1.setPicture("https://cdn.dribbble.com/users/17619/screenshots/1612999/whiskey.png");
            crate1.setPrice(299.99);
            crate1.setInStock(100L);
            crate1.setBottle(true);


            Crate crate2 = new Crate();
            crate2.setName("Vodka Crate");
            crate2.setPicture("https://i.etsystatic.com/13810397/r/il/dfb095/3752603339/il_570xN.3752603339_gjm1.jpg");
            crate2.setPrice(199.99);
            crate2.setInStock(150L);
            crate2.setBottle(true);


            // Save the demo data
            crateRepository.save(crate1);
            crateRepository.save(crate2);
        }
    }
}
