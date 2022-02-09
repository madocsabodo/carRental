package edu.datafusion.CarRental.models;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
public class Car {
    private Long id;
    private String make;
    private String model;
    private FuelType fuelType;
    private BodyType bodyType;
    private Color color;
    private LocalDate registrationDate;
    private GearType gearType;
    private int hpPower;
    private int nrOfDoors;
    private int nrOfSeats;
    private int dailyRate;
    private int hourlyRate;

    @Override
    public String toString() {
        return "Car [id=" + id + ", make=" + make + ", model=" + model + ", fuel_type=" + fuelType + ", body_type="
                + bodyType + ", color=" + color + ", registration_date=" + registrationDate + ", gear_type="
                + gearType + ", hp_power=" + hpPower + ", nr_of_doors=" + nrOfDoors + ", nr_of_seats=" + nrOfSeats
                + ", daily_rate=" + dailyRate + ", hourly_rate=" + hourlyRate + "]";
    }

}