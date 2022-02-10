package edu.datafusion.CarRental.models;


import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
}