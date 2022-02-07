package edu.datafusion.CarRental.models;


import java.time.LocalDate;

public class CarModel {
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

    public GearType getGearType() {
        return gearType;
    }

    public void setGearType(GearType gearType) {
        this.gearType = gearType;
    }

    public int getHpPower() {
        return hpPower;
    }

    public void setHpPower(int hpPower) {
        this.hpPower = hpPower;
    }

    public int getNrOfDoors() {
        return nrOfDoors;
    }

    public void setNrOfDoors(int nrOfDoors) {
        this.nrOfDoors = nrOfDoors;
    }

    public int getNrOfSeats() {
        return nrOfSeats;
    }

    public void setNrOfSeats(int nrOfSeats) {
        this.nrOfSeats = nrOfSeats;
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


    @Override
    public String toString() {
        return "Car [id=" + id + ", make=" + make + ", model=" + model + ", fuel_type=" + fuelType + ", body_type="
                + bodyType + ", color=" + color + ", registration_date=" + registrationDate + ", gear_type="
                + gearType + ", hp_power=" + hpPower + ", nr_of_doors=" + nrOfDoors + ", nr_of_seats=" + nrOfSeats
                + ", daily_rate=" + dailyRate + ", hourly_rate=" + hourlyRate + "]";
    }

}