package edu.datafusion.CarRental.repositories;

import edu.datafusion.CarRental.models.RentalModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
@ApplicationScope
public class RentalRepository {
    List<Rental> rentals = new ArrayList<Rental>();
    private static final String CSV_FILE_STRING3 = "C:\\Java_gyakorlat\\CarRental\\src\\main\\resources\\rentals.csv";
    private static final String SPLIT_STRING = ",";

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ClientRepository clientRepository;

    @PostConstruct
    public void readRentals() {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_STRING3))) {
            while((line = br.readLine()) != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                String[] data = line.split(SPLIT_STRING);
                int client_id = Integer.parseInt(data[1]);
                int car_id = Integer.parseInt(data[2]);
                Car searchedCar = carRepository.findCarById(car_id);
                Client searchedClient = clientRepository.findClientById(client_id);
                Rental rental = new Rental(Integer.parseInt(data[0]), searchedCar.getId(), searchedClient.getId());
                LocalDate local_date = LocalDate.parse(data[3]);
                rental.setRentalStartDate(local_date);
                rental.setRentedHours(Integer.parseInt(data[4]));
                rental.setWasReturned( data[5].equals("true") ? true : false);

                rentals.add(rental);

            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public List<Rental> findAll() {
        return rentals;
    }

    public Rental addRental(int carId, int clientId) {
        Car searchedCar = carRepository.findCarById(carId);
        Client searchedClient = clientRepository.findClientById(clientId);
        Rental newRental = new Rental(0, searchedCar.getId(), searchedClient.getId());
        rentals.add(newRental);
        return newRental;
    }
}
