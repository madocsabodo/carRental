package edu.datafusion.CarRental.repository.entity;

import edu.datafusion.CarRental.models.BodyType;
import edu.datafusion.CarRental.models.Color;
import edu.datafusion.CarRental.models.FuelType;
import edu.datafusion.CarRental.models.GearType;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "car")
@NamedQueries({
        @NamedQuery(name= CarBE.GET_ALL_CARS, query = "select c from CarBE c")
})
public class CarBE implements Serializable {
    public static final String GET_ALL_CARS = "getAllCars";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "fuel_type")
    private FuelType fuelType;

    @Column(name = "body_type")
    private BodyType bodyType;

    @Column(name = "color")
    private Color color;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "hp_power")
    private int hpPower;

    @Column(name = "gear_type")
    private GearType gearType;

    @Column(name = "nr_of_doors")
    private int nrOfDoors;

    @Column(name = "nr_of_seats")
    private int nrOfSeats;

    @Column(name = "daily_rate")
    private int dailyRate;

    @Column(name = "hourly_rate")
    private int hourlyRate;
}
