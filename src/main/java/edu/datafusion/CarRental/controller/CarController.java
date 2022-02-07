package edu.datafusion.CarRental.controller;

import edu.datafusion.CarRental.models.CarModel;
import edu.datafusion.CarRental.repositories.CarRepository;
import edu.datafusion.CarRental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/car")
public class CarController {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarService carService;

    @GetMapping
    public List<CarModel> listCars() {
        return carService.findAll();
    }

    @PostMapping
    public CarModel addCar(@RequestBody CarModel carModel) {
        return carService.addCar(carModel);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable int id) {
        carRepository.deleteById(id);
    }
}
