package edu.datafusion.CarRental.service;

import edu.datafusion.CarRental.models.CarModel;
import edu.datafusion.CarRental.repositories.Car;
import edu.datafusion.CarRental.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<CarModel> findAll() {
        return carRepository.findAll().stream()
                .map(this::toCarModel)
                .collect(Collectors.toList());
    }

    public CarModel addCar(CarModel carModel) {
        Car car = carRepository.addCar(toCar(carModel));
        return toCarModel(car);
    }

    private Car toCar(CarModel carModel) {
        Car car = new Car();
        car.setMake(carModel.getMake());
        car.setModel(carModel.getModel());
        car.setFuelType(carModel.getFuelType());
        car.setBodyType(carModel.getBodyType());
        car.setColor(carModel.getColor());
        car.setRegistrationDate(carModel.getRegistrationDate());
        car.setHpPower(carModel.getHpPower());
        car.setGearType(carModel.getGearType());
        car.setNrOfDoors(carModel.getNrOfDoors());
        car.setNrOfSeats(carModel.getNrOfSeats());
        car.setDailyRate(carModel.getDailyRate());
        car.setHourlyRate(carModel.getHourlyRate());

        return car;
    }

    private CarModel toCarModel(Car car) {
        CarModel carModel = new CarModel();
        carModel.setId(car.getId());
        carModel.setMake(car.getMake());
        carModel.setModel(car.getModel());
        carModel.setFuelType(car.getFuelType());
        carModel.setBodyType(car.getBodyType());
        carModel.setColor(car.getColor());
        carModel.setRegistrationDate(car.getRegistrationDate());
        carModel.setHpPower(car.getHpPower());
        carModel.setGearType(car.getGearType());
        carModel.setNrOfDoors(car.getNrOfDoors());
        carModel.setNrOfSeats(car.getGetNrOfSeats());
        carModel.setDailyRate(car.getDailyRate());
        carModel.setHourlyRate(car.getHourlyRate());

        return carModel;
    }
}
