package edu.datafusion.CarRental.controller;

import edu.datafusion.CarRental.models.Car;
import edu.datafusion.CarRental.service.CarService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    @ApiOperation(value = "Get All Cars which are available in the system. " +
            "This operation does not requires any role." , authorizations = {@Authorization(value="basicAuth")})
    public List<Car> listCars() {
        return carService.findAll();
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable int id) {
        carService.deleteById(id);
    }
}
