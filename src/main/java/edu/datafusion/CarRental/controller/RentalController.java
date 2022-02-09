package edu.datafusion.CarRental.controller;

import edu.datafusion.CarRental.models.RentalModel;
import edu.datafusion.CarRental.repository.RentalRepository;
import edu.datafusion.CarRental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rental")
public class RentalController {
    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private RentalService rentalService;

    @GetMapping
    public List<RentalModel> listRentals(){
        return rentalService.findAll();
    }

    @PostMapping
    public RentalModel addRental(@RequestParam int carId, @RequestParam int clientId) {
        return rentalService.addRental(carId, clientId);
    }

}
