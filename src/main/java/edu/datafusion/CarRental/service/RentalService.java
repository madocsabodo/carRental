package edu.datafusion.CarRental.service;

import edu.datafusion.CarRental.models.RentalModel;
import edu.datafusion.CarRental.repositories.Rental;
import edu.datafusion.CarRental.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class    RentalService {
    @Autowired
    private RentalRepository rentalRepository;

    public List<RentalModel> findAll() {
        return rentalRepository.findAll().stream()
                .map(this::toRentalModel)
                .collect(Collectors.toList());
    }

    public RentalModel addRental(int carId, int clientId) {
        RentalModel rentalResponse = new RentalModel();
        Rental rental = rentalRepository.addRental(carId, clientId);
        return toRentalModel(rental);
    }

    private Rental toRental(RentalModel rentalModel) {
        Rental rental = new Rental();
        rental.setId(rentalModel.getId());
        rental.setClientId(rentalModel.getClientId());
        rental.setCarId(rentalModel.getCarId());
        rental.setRentalStartDate(rentalModel.getRentalStartDate());
        rental.setRentedHours(rentalModel.getRentedHours());
        rental.setWasReturned(rentalModel.isWasReturned());

        return rental;
    }

    private RentalModel toRentalModel(Rental rental) {
        RentalModel rentalModel = new RentalModel();
        rentalModel.setId(rental.getId());
        rentalModel.setClientId(rental.getClientId());
        rentalModel.setCarId(rental.getCarId());
        rentalModel.setRentalStartDate(rental.getRentalStartDate());
        rentalModel.setRentedHours(rental.getRentedHours());
        rentalModel.setWasReturned(rental.isWasReturned());

        return rentalModel;
    }
}
