package edu.datafusion.CarRental.service;

import edu.datafusion.CarRental.models.Car;
import edu.datafusion.CarRental.repository.CarBE;
import edu.datafusion.CarRental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.findAll().stream()
                .map(this::toCarModel)
                .collect(Collectors.toList());
    }

    public Car addCar(Car carModel) {
        CarBE car = carRepository.addCar(toCar(carModel));
        return toCarModel(car);
    }

    private CarBE toCar(Car carModel) {
        CarBE car = new CarBE();
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

    /**
     * Entity to Model mapping fluent way with lombok builder.
     *
     * @param car
     * @return
     */
    private Car toCarModel(CarBE car) {
        return Car.builder()
                .id(car.getId())
                .make(car.getMake())
                .model(car.getModel())
                .fuelType(car.getFuelType())
                .bodyType(car.getBodyType())
                .color(car.getColor())
                .registrationDate(car.getRegistrationDate())
                .hpPower(car.getHpPower())
                .gearType(car.getGearType())
                .nrOfDoors(car.getNrOfDoors())
                .nrOfSeats(car.getNrOfSeats())
                .dailyRate(car.getDailyRate())
                .hourlyRate(car.getHourlyRate())
                .build();
    }

    public void deleteById(long id) {
        carRepository.deleteById(id);
    }
}
