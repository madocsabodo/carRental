package edu.datafusion.CarRental.models;

import java.time.LocalDate;

public class RentalModel {
    private int id;
    private LocalDate rentalStartDate;
    private int rentedHours;
    private boolean wasReturned;
    private Long carId;
    private Long clientId;


    public RentalModel(int id, Long carId, Long clientId) {
        this.id = id;
        this.carId = carId;
        this.clientId = clientId;
    }

    public RentalModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(LocalDate rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    public int getRentedHours() {
        return rentedHours;
    }

    public void setRentedHours(int rentedHours) {
        this.rentedHours = rentedHours;
    }

    public boolean isWasReturned() {
        return wasReturned;
    }

    public void setWasReturned(boolean wasReturned) {
        this.wasReturned = wasReturned;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}

