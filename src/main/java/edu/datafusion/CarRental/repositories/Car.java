package edu.datafusion.CarRental.repositories;

import edu.datafusion.CarRental.models.BodyType;
import edu.datafusion.CarRental.models.Color;
import edu.datafusion.CarRental.models.FuelType;
import edu.datafusion.CarRental.models.GearType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "car")
@NamedQueries({
        @NamedQuery(name= Car.GET_ALL_CARS, query = "select c from Car c")
})
public class Car implements Serializable {
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
    private int getNrOfSeats;

    @Column(name = "daily_rate")
    private int dailyRate;

    @Column(name = "hourly_rate")
    private int hourlyRate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getHpPower() {
        return hpPower;
    }

    public void setHpPower(int hpPower) {
        this.hpPower = hpPower;
    }

    public GearType getGearType() {
        return gearType;
    }

    public void setGearType(GearType gearType) {
        this.gearType = gearType;
    }

    public int getNrOfDoors() {
        return nrOfDoors;
    }

    public void setNrOfDoors(int nrOfDoors) {
        this.nrOfDoors = nrOfDoors;
    }

    public int getGetNrOfSeats() {
        return getNrOfSeats;
    }

    public void setGetNrOfSeats(int getNrOfSeats) {
        this.getNrOfSeats = getNrOfSeats;
    }

    public int getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(int dailyRate) {
        this.dailyRate = dailyRate;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setNrOfSeats(int parseInt) {
    }
}
