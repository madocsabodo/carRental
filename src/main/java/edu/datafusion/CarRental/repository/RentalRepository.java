package edu.datafusion.CarRental.repository;

import edu.datafusion.CarRental.repository.entity.CarBE;
import edu.datafusion.CarRental.repository.entity.RentalBE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@ApplicationScope
public class RentalRepository {
    List<RentalBE> rentalBES = new ArrayList<RentalBE>();
    private static final String CSV_FILE_STRING3 = "C:\\Java_gyakorlat\\CarRental\\src\\main\\resources\\rentals.csv";
    private static final String SPLIT_STRING = ",";

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ClientRepository clientJpaRepository;

    @PostConstruct
    public void readRentals() {

    }

    public List<RentalBE> findAll() {
        return rentalBES;
    }

    public RentalBE addRental(int carId, int clientId) {
        CarBE searchedCar = carRepository.findCarById(carId);

        return null;
    }
}
