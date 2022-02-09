package edu.datafusion.CarRental.service;

import edu.datafusion.CarRental.models.RentalModel;
import edu.datafusion.CarRental.repository.RentalBE;
import edu.datafusion.CarRental.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;

    public List<RentalModel> findAll() {
        return rentalRepository.findAll().stream()
                .map(this::toRentalModel)
                .collect(Collectors.toList());
    }

    public RentalModel addRental(int carId, int clientId) {
        RentalModel rentalResponse = new RentalModel();
        RentalBE rentalBE = rentalRepository.addRental(carId, clientId);
        return toRentalModel(rentalBE);
    }

    private RentalBE toRental(RentalModel rentalModel) {
        RentalBE rentalBE = new RentalBE();
        rentalBE.setId(rentalModel.getId());
        rentalBE.setClientId(rentalModel.getClientId());
        rentalBE.setCarId(rentalModel.getCarId());
        rentalBE.setRentalStartDate(rentalModel.getRentalStartDate());
        rentalBE.setRentedHours(rentalModel.getRentedHours());
        rentalBE.setWasReturned(rentalModel.isWasReturned());

        return rentalBE;
    }

    private RentalModel toRentalModel(RentalBE rentalBE) {
        RentalModel rentalModel = new RentalModel();
        rentalModel.setId(rentalBE.getId());
        rentalModel.setClientId(rentalBE.getClientId());
        rentalModel.setCarId(rentalBE.getCarId());
        rentalModel.setRentalStartDate(rentalBE.getRentalStartDate());
        rentalModel.setRentedHours(rentalBE.getRentedHours());
        rentalModel.setWasReturned(rentalBE.isWasReturned());

        return rentalModel;
    }
}
